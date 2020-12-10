package com.michael.pokemon.mvi.pokemonlist.view

sealed class PokemonEffect {
    data class LoadMorePokemonListSuccess(val data: List<PokemonItem>) : PokemonEffect()
    object LoadMorePokemonListError : PokemonEffect()
    data class RefreshPokemonListSuccess(val data: List<PokemonItem>) : PokemonEffect()
    object RefreshPokemonListError : PokemonEffect()
}