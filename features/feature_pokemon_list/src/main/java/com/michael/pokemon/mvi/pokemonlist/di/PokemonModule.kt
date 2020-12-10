package com.michael.pokemon.mvi.pokemonlist.di

import android.content.Context
import com.michael.data_source.di.DataModule
import com.michael.data_source.di.DataScope
import com.michael.data_source.repository.PokemonRepository
import com.michael.data_source.repository.PokemonRepositoryImpl
import com.michael.data_source.service.PokemonService
import com.michael.lib_core.thread.ApplicationSchedulerProvider
import com.michael.lib_core.thread.SchedulerProvider
import com.michael.pokemon.mvi.pokemonlist.domain.PokemonUseCase
import com.michael.pokemon.mvi.pokemonlist.view.PokemonListState
import dagger.Module
import dagger.Provides

@Module(includes = [DataModule::class])
class PokemonModule(val context: Context) {

    @PokemonScope
    @Provides
    fun provideRepository(@DataScope service: PokemonService): PokemonRepository {
        return PokemonRepositoryImpl(service)
    }

    @PokemonScope
    @Provides
    fun provideUseCase(repository: PokemonRepository): PokemonUseCase {
        return PokemonUseCase(repository)
    }

    @PokemonScope
    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = ApplicationSchedulerProvider()

    @PokemonScope
    @Provides
    fun providePokemonListState(): PokemonListState = PokemonListState()
}