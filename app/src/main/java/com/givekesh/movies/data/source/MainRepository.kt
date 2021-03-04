package com.givekesh.movies.data.source

import com.givekesh.movies.data.model.Movies
import com.givekesh.movies.data.model.OnTheaters
import com.givekesh.movies.data.source.remote.NetworkApi
import com.givekesh.movies.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository constructor(
    private val networkApi: NetworkApi
) {
    suspend fun fetchPopularMovies(): Flow<DataState<Movies>> = flow {
        emit(DataState.Loading)
        try {
            val result = networkApi.fetchPopularMovies()
            emit(DataState.Success(result))
        } catch (exception: Exception) {
            emit(DataState.Failed(exception))
        }
    }

    suspend fun fetchTopRatedMovies(): Flow<DataState<Movies>> = flow {
        emit(DataState.Loading)
        try {
            val result = networkApi.fetchTopRatedMovies()
            emit(DataState.Success(result))
        } catch (exception: Exception) {
            emit(DataState.Failed(exception))
        }
    }

    suspend fun fetchOnTheaters(): Flow<DataState<OnTheaters>> = flow {
        emit(DataState.Loading)
        try {
            val result = networkApi.fetchOnTheaters()
            emit(DataState.Success(result))
        } catch (exception: Exception) {
            emit(DataState.Failed(exception))
        }
    }

    suspend fun searchForMovies(query: String): Flow<DataState<Movies>> = flow {
        emit(DataState.Loading)
        try {
            val result = networkApi.searchForMovies(query)
            emit(DataState.Success(result))
        } catch (exception: Exception) {
            emit(DataState.Failed(exception))
        }
    }
}