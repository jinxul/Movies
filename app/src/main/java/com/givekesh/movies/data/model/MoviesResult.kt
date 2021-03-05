package com.givekesh.movies.data.model

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class MoviesResult(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: ArrayList<Int>,
    val id: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Number,
    @SerializedName("poster_path")
    @Nullable val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Number,
    @SerializedName("vote_count")
    val voteCount: Int
)