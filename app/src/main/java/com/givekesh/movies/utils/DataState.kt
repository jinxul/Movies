package com.givekesh.movies.utils

sealed class DataState<out R> {
    object Idle : DataState<Nothing>()
    object Loading : DataState<Nothing>()
    object Refreshing : DataState<Nothing>()
    class Success<out T>(val data: T) : DataState<T>()
    class Failed(val exception: Exception) : DataState<Nothing>()
}