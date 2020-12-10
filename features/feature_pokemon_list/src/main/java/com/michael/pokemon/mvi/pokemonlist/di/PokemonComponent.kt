package com.michael.pokemon.mvi.pokemonlist.di

import com.michael.pokemon.mvi.pokemonlist.view.PokemonListActivity
import dagger.Component

@PokemonScope
@Component(
    modules = [
        PokemonModule::class,
        PokemonViewModelModule::class
    ]
)
interface PokemonComponent {
    fun inject(activity: PokemonListActivity)
}