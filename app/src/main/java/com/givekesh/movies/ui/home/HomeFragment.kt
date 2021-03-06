package com.givekesh.movies.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.givekesh.movies.databinding.FragmentHomeBinding
import com.givekesh.movies.ui.home.adapters.MoviesAdapter
import com.givekesh.movies.utils.DataState
import com.givekesh.movies.utils.MainIntent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var topRatedMoviesAdapter: MoviesAdapter
    private lateinit var onTheatersAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeObserver()

        setupRecyclerViews()

        sendIntentToChannel(MainIntent.FetchTopRatedMovies)
        sendIntentToChannel(MainIntent.FetchOnTheaters)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun subscribeObserver() {
        lifecycleScope.launch {

            homeViewModel.topRatedMovies.combine(
                homeViewModel.onTheaters
            ) { topRatedMovies, onTheaters ->
                when (topRatedMovies) {
                    is DataState.Idle -> Unit
                    is DataState.Loading -> Unit
                    is DataState.Refreshing -> Unit
                    is DataState.Success -> {
                        topRatedMoviesAdapter
                            .updateItems(topRatedMovies.data.results)
                    }
                    is DataState.Failed -> Unit
                }
                when (onTheaters) {
                    is DataState.Idle -> Unit
                    is DataState.Loading -> Unit
                    is DataState.Refreshing -> Unit
                    is DataState.Success -> {
                        onTheatersAdapter
                            .updateItems(onTheaters.data.results)
                    }
                    is DataState.Failed -> Unit
                }
            }.collect()
        }
    }

    private fun setupRecyclerViews() {
        topRatedMoviesAdapter = MoviesAdapter()
        onTheatersAdapter = MoviesAdapter()

        binding.apply {
            topRatedList.adapter = topRatedMoviesAdapter
            onTheatersList.adapter = onTheatersAdapter
        }
    }

    private fun sendIntentToChannel(intent: MainIntent) {
        lifecycleScope.launch {
            homeViewModel.channel.send(intent)
        }
    }
}