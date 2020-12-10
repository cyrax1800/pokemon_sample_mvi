package com.michael.pokemon.mvi.pokemonlist.view

import android.view.View
import com.michael.pokemon.mvi.pokemonlist.R
import com.michael.pokemon.mvi.pokemonlist.databinding.PokemonItemBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

data class PokemonItem(
    val name: String,
    override val layoutRes: Int = R.layout.pokemon_item,
    override val type: Int = R.layout.pokemon_item
) : AbstractItem<PokemonItem.ViewHolder>() {

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<PokemonItem>(view) {
        private val binding = PokemonItemBinding.bind(view)

        override fun bindView(item: PokemonItem, payloads: MutableList<Any>) {
            binding.textView.text = item.name
        }

        override fun unbindView(item: PokemonItem) {
            binding.textView.text = ""
        }
    }
}