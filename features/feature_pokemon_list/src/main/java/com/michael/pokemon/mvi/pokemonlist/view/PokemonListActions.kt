package com.michael.pokemon.mvi.pokemonlist.view

sealed class PokemonListActions {
    object LoadMore : PokemonListActions()
    object Refresh : PokemonListActions()
    data class LoadAsync(val id: String) : PokemonListActions()
}