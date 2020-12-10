package com.michael.pokemon.mvi.pokemonlist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.michael.lib_core.viewmodel.ViewModelFactory
import com.michael.lib_core.viewmodel.ViewModelKey
import com.michael.pokemon.mvi.pokemonlist.di.PokemonScope
import com.michael.pokemon.mvi.pokemonlist.view.PokemonListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PokemonViewModelModule {

    @PokemonScope
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PokemonListViewModel::class)
    abstract fun bindPokemonListViewModel(viewModel: PokemonListViewModel): ViewModel
}
