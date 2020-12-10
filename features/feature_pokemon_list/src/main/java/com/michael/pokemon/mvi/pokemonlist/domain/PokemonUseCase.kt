package com.michael.pokemon.mvi.pokemonlist.domain

import com.michael.api.responses.ResultState
import com.michael.data_source.model.NamedApiResourceList
import com.michael.data_source.repository.PokemonRepository
import com.michael.pokemon.mvi.pokemonlist.view.PokemonItem
import javax.inject.Inject

class PokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

    fun tranformNamedApiResourcesToPokemonItem(data: NamedApiResourceList): List<PokemonItem> {
        return data.results.map {
            PokemonItem(it.name)
        }
    }

    suspend fun getPokemonList(limit: Int, offset: Int): ResultState<List<PokemonItem>> {
        return try {
            val response = repository.getPokemons(limit, offset)
            if (response.isSuccessful) {
                ResultState.Success(tranformNamedApiResourcesToPokemonItem(response.body()!!))
            } else {
                ResultState.Error(response.message())
            }
        } catch (e: Throwable) {
            ResultState.Error(e.message)
        }
    }
}