package com.givekesh.movies.data.model

import com.google.gson.annotations.SerializedName

data class OnTheaters(
    val dates: MovieDates,
    val page: Int,
    val result: ArrayList<MoviesResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)

data class MovieDates(
    val maximum: String,
    val minimum: String
)