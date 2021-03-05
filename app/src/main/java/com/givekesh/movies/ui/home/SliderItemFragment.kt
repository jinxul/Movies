package com.givekesh.movies.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.givekesh.movies.data.model.MoviesResult
import com.givekesh.movies.databinding.ItemSliderBinding

class SliderItemFragment(private val movie: MoviesResult) : Fragment() {
    private var _binding: ItemSliderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ItemSliderBinding.inflate(inflater, container, false)
        binding.movie = movie
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}