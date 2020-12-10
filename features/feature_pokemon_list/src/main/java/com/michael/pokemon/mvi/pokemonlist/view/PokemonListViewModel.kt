package com.michael.pokemon.mvi.pokemonlist.view

import com.michael.api.responses.ResultState
import com.michael.lib_core.Consts.LIMIT
import com.michael.lib_core.thread.SchedulerProvider
import com.michael.lib_core.viewmodel.BaseViewModel
import com.michael.pokemon.mvi.pokemonlist.domain.PokemonUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonListViewModel @Inject constructor(
    private val usecase: PokemonUseCase,
    private val schedulerProvider: SchedulerProvider,
    private val initialState: PokemonListState
) : BaseViewModel(schedulerProvider), PokemonListViewModelContract, CoroutineScope {

    private val state = MutableStateFlow(initialState)
    private val uiEvent = MutableSharedFlow<PokemonListActions>()

    override fun viewState(): StateFlow<PokemonListState> = state

    fun dispatch(actions: PokemonListActions) {
        launch(schedulerProvider.io()) {
            uiEvent.emit(actions)
        }
    }

    fun bindEvent() {
        launch(schedulerProvider.ui()) {
            merge(loadMoreSharedFlowAction(), refreshSharedFlowAction())
                .flowOn(schedulerProvider.io())
                .scan(initialState, ::reducer)
                .collect {
                    state.value = it
                }
        }
    }

    private fun loadMoreSharedFlowAction() = uiEvent.filter {
        it is PokemonListActions.LoadMore
    }.flatMapMerge {
        flow {
            emit(usecase.getPokemonList(LIMIT, state.value.offset))
        }.flowOn(schedulerProvider.io()).map {
            if (it is ResultState.Success) {
                PokemonEffect.LoadMorePokemonListSuccess(it.data)
            } else {
                PokemonEffect.LoadMorePokemonListError
            }
        }
    }

    private fun refreshSharedFlowAction() = uiEvent.filter {
        it is PokemonListActions.Refresh
    }.flatMapMerge {
        flow {
            emit(usecase.getPokemonList(LIMIT, 0))
        }.flowOn(schedulerProvider.io()).map {
            if (it is ResultState.Success) {
                PokemonEffect.RefreshPokemonListSuccess(it.data)
            } else {
                PokemonEffect.RefreshPokemonListError
            }
        }
    }

    private suspend fun reducer(
        currentState: PokemonListState,
        effect: PokemonEffect
    ): PokemonListState {
        return when (effect) {
            is PokemonEffect.LoadMorePokemonListSuccess -> {
                currentState.copy(
                    listItem = state.value.listItem + effect.data,
                    offset = state.value.offset + LIMIT,
                    page = state.value.page + 1
                )
            }
            is PokemonEffect.RefreshPokemonListSuccess -> {
                currentState.copy(
                    listItem = effect.data,
                    offset = LIMIT,
                    page = 1
                )
            }
            else -> {
                currentState
            }
        }
    }
}