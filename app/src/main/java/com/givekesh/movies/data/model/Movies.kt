package com.givekesh.movies.data.model

import com.google.gson.annotations.SerializedName

data class Movies(
    val page: Int,
    val results: ArrayList<MoviesResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)

