package com.givekesh.movies.data.source.remote

import com.givekesh.movies.data.model.OnTheaters
import com.givekesh.movies.data.model.Movies
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {
    @GET("movie/popular")
    suspend fun fetchPopularMovies(): Movies

    @GET("movie/top_rated")
    suspend fun fetchTopRatedMovies(): Movies

    @GET("movie/now_playing")
    suspend fun fetchOnTheaters(): OnTheaters

    @GET("/search/movie")
    suspend fun searchForMovies(@Query("query") query: String): Movies
}