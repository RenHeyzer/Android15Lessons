package com.example.android4_2.ui.fragments.anime

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4_2.R
import com.example.android4_2.databinding.FragmentAnimeBinding
import com.example.android4_2.ui.adapters.KitsuAdapter
import com.example.android4_2.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : Fragment(R.layout.fragment_anime) {

    private val binding by viewBinding(FragmentAnimeBinding::bind)
    private val viewModel by viewModels<AnimeViewModel>()
    private val kitsuAdapter = KitsuAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        subscribeToAnime()
//        handlePagingState()
    }

    private fun initialize() = with(binding) {
        rvAnime.adapter = kitsuAdapter
    }

    private fun subscribeToAnime() {
        /*viewModel.animeLiveData.observe(viewLifecycleOwner) {
            viewLifecycleOwner.lifecycleScope.launch {
                kitsuAdapter.submitData(it)
            }
        }*/
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.animeState.collect {
                    binding.progressBar.isVisible = it is UIState.Loading
                    when (it) {
                        UIState.Loading -> Log.e("anime", it.toString())
                        is UIState.Error -> {
                            Log.e("anime", it.message, it.throwable)
                        }

                        is UIState.Success -> {
//                            it.data?.let(kitsuAdapter::submitList)
                        }
                    }
                }
            }
        }
    }

    /*private fun handlePagingState() = with(binding) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                kitsuAdapter.loadStateFlow.collect {
                    progressBar.isVisible = it.source.refresh is LoadState.Loading
                    appendProgress.isVisible = it.source.append is LoadState.Loading
                    prependProgress.isVisible = it.source.prepend is LoadState.Loading
                }
            }
        }
    }*/
}