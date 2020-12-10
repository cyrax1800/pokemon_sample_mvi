package com.michael.pokemon.mvi.pokemonlist.view

data class PokemonListState(
    val listItem: List<PokemonItem> = emptyList(),
    val page: Int = 1,
    val offset: Int = 0
)