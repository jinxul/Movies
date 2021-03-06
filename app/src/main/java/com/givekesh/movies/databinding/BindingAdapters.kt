package com.givekesh.movies.databinding

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.givekesh.movies.utils.Constants
import com.google.android.material.imageview.ShapeableImageView

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("loadWithGlide")
    fun loadWithGlide(view: ShapeableImageView, url: String) {
        Glide.with(view.context).load(Constants.IMAGE_URL + url).into(view)
    }
}