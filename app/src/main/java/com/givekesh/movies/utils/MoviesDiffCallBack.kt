package com.givekesh.movies.utils

import androidx.recyclerview.widget.DiffUtil
import com.givekesh.movies.data.model.MoviesResult

class MoviesDiffCallBack(
    private val oldList: ArrayList<MoviesResult>,
    private val newList: ArrayList<MoviesResult>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].originalTitle == newList[newItemPosition].originalTitle
}