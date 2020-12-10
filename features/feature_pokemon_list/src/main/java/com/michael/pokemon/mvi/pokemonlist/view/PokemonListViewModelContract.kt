package com.michael.pokemon.mvi.pokemonlist.view

import kotlinx.coroutines.flow.StateFlow

interface PokemonListViewModelContract {
    fun viewState(): StateFlow<PokemonListState>
}