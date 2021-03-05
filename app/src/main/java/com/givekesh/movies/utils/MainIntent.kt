package com.givekesh.movies.utils

sealed class MainIntent {
    object FetchPopularMovies : MainIntent()
    object FetchTopRatedMovies : MainIntent()
    object FetchOnTheaters : MainIntent()
    class SearchForMovies(val query: String) : MainIntent()
}