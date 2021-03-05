package com.givekesh.movies.ui.home.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.givekesh.movies.data.model.MoviesResult
import com.givekesh.movies.ui.home.SliderItemFragment

class MovieSliderAdapter(
    fragment: Fragment,
    private val items: ArrayList<MoviesResult>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = items.size

    override fun createFragment(position: Int): Fragment = SliderItemFragment(items[position])
}