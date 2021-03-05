package com.givekesh.movies.ui.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.givekesh.movies.data.model.Movies
import com.givekesh.movies.data.model.OnTheaters
import com.givekesh.movies.data.source.MainRepository
import com.givekesh.movies.utils.DataState
import com.givekesh.movies.utils.MainIntent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val repository: MainRepository
) : ViewModel() {

    val channel = Channel<MainIntent>()

    private val _popularMovies = MutableStateFlow<DataState<Movies>>(DataState.Idle)
    val popularMovies: StateFlow<DataState<Movies>> get() = _popularMovies

    private val _topRatedMovies = MutableStateFlow<DataState<Movies>>(DataState.Idle)
    val topRatedMovies: StateFlow<DataState<Movies>> get() = _topRatedMovies

    private val _onTheaters = MutableStateFlow<DataState<OnTheaters>>(DataState.Idle)
    val onTheaters: StateFlow<DataState<OnTheaters>> get() = _onTheaters

    private val _searchResult = MutableStateFlow<DataState<Movies>>(DataState.Idle)
    val searchResult: StateFlow<DataState<Movies>> get() = _searchResult

    init {
        handleIntents()
    }

    private fun handleIntents() {
        viewModelScope.launch {
            channel.consumeAsFlow().collect { mainIntent ->
                when (mainIntent) {
                    MainIntent.FetchPopularMovies -> repository.fetchPopularMovies()
                        .onEach { _popularMovies.value = it }
                        .launchIn(viewModelScope)
                    MainIntent.FetchTopRatedMovies -> repository.fetchTopRatedMovies()
                        .onEach { _topRatedMovies.value = it }
                        .launchIn(viewModelScope)
                    MainIntent.FetchOnTheaters -> repository.fetchOnTheaters()
                        .onEach { _onTheaters.value = it }
                        .launchIn(viewModelScope)
                    is MainIntent.SearchForMovies -> repository.searchForMovies(mainIntent.query)
                        .onEach { _searchResult.value = it }
                        .launchIn(viewModelScope)
                }
            }
        }
    }
}