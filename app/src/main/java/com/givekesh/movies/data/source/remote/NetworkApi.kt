package com.givekesh.movies.data.source.remote

import com.givekesh.movies.data.model.OnTheaters
import com.givekesh.movies.data.model.Movies
import com.givekesh.movies.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {
    @GET("movie/popular?api_key=${Constants.API_KEY}")
    suspend fun fetchPopularMovies(): Movies

    @GET("movie/top_rated?api_key=${Constants.API_KEY}")
    suspend fun fetchTopRatedMovies(): Movies

    @GET("movie/now_playing?api_key=${Constants.API_KEY}")
    suspend fun fetchOnTheaters(): OnTheaters

    @GET("/search/movie")
    suspend fun searchForMovies(@Query("query") query: String): Movies
}