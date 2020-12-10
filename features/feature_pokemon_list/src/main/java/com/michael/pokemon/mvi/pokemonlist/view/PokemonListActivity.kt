package com.michael.pokemon.mvi.pokemonlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.michael.pokemon.mvi.pokemonlist.databinding.ActivityMainBinding
import com.michael.pokemon.mvi.pokemonlist.di.DaggerPokemonComponent
import com.michael.pokemon.mvi.pokemonlist.di.PokemonModule
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.GenericItemAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.DiffCallback
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class PokemonListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: PokemonListViewModel

    private val itemAdapter = ItemAdapter<PokemonItem>()
    private val adapter: FastAdapter<GenericItem> by lazy { FastAdapter.with(itemAdapter as ItemAdapter<GenericItem>) }
    private val footerAdapter = GenericItemAdapter()

    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initInjector()
        initView()
    }

    override fun onResume() {
        super.onResume()
        initObserver()
    }

    override fun onPause() {
        super.onPause()
        job?.cancel()
    }

    private fun initInjector() {
        DaggerPokemonComponent.builder()
            .pokemonModule(PokemonModule(this))
            .build()
            .inject(this)
    }

    private fun initView() {
        viewModel = ViewModelProviders
            .of(this, viewModelFactory)
            .get(PokemonListViewModel::class.java)

        viewModel.bindEvent()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter.addAdapter(1, footerAdapter)
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(
                this@PokemonListActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            recyclerView.adapter = adapter

            var tmp = 0
            swipeRefreshLayout.setOnRefreshListener {
                if (tmp  % 2 == 0) {
                    viewModel.dispatch(PokemonListActions.Refresh)
                } else {
                    viewModel.dispatch(PokemonListActions.LoadMore)
                }
                tmp++
                binding.swipeRefreshLayout.isRefreshing = false
            }
        }
    }

    private fun initObserver() {
        job = lifecycleScope.launchWhenResumed {
            viewModel.viewState().collect {
                Log.d("tmp", "render")
                binding.swipeRefreshLayout.isRefreshing = false
            }
        }
    }

    object PokemonDiffCallback : DiffCallback<PokemonItem> {
        override fun areContentsTheSame(
            oldItem: PokemonItem,
            newItem: PokemonItem
        ): Boolean = oldItem.toString() == newItem.toString()

        override fun areItemsTheSame(
            oldItem: PokemonItem,
            newItem: PokemonItem
        ): Boolean = oldItem == newItem

        override fun getChangePayload(
            oldItem: PokemonItem,
            oldItemPosition: Int,
            newItem: PokemonItem,
            newItemPosition: Int
        ): Any {
            return newItemPosition
        }
    }

    private fun render(state: PokemonListState) {
        FastAdapterDiffUtil.set(itemAdapter, state.listItem, PokemonDiffCallback)
    }
}