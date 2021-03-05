package com.givekesh.movies.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.givekesh.movies.BR
import com.givekesh.movies.data.model.MoviesResult
import com.givekesh.movies.databinding.ItemMovieListBinding
import com.givekesh.movies.utils.MoviesDiffCallBack

class MoviesAdapter : RecyclerView.Adapter<MoviesViewHolder>() {
    private val moviesList = ArrayList<MoviesResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieListBinding.inflate(inflater, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int = moviesList.size

    private fun getItem(index: Int) = moviesList[index]

    fun updateItems(items: ArrayList<MoviesResult>) {
        val diffCallback = MoviesDiffCallBack(moviesList, items)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(diffCallback)
        moviesList.clear()
        moviesList.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }
}

class MoviesViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(movies: MoviesResult) {
        binding.setVariable(BR.movies, movies)
    }
}