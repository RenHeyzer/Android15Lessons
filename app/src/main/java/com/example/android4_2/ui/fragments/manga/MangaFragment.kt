package com.example.android4_2.ui.fragments.manga

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4_2.R
import com.example.android4_2.databinding.FragmentMangaBinding
import com.example.android4_2.ui.adapters.KitsuAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : Fragment(R.layout.fragment_manga) {

    private val binding by viewBinding(FragmentMangaBinding::bind)
    private val kitsuAdapter = KitsuAdapter()
    private val viewModels by viewModels<MangaViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        subscribeToManga()
        handlePagingState()
    }

    private fun initialize() {
        binding.rvManga.adapter = kitsuAdapter
    }

    private fun subscribeToManga() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModels.mangaState.collectLatest {
                    kitsuAdapter.submitData(it)
                }
            }
        }
    }

    private fun handlePagingState() = with(binding) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                kitsuAdapter.loadStateFlow.collect {
                    progressBar.isVisible = it.source.refresh is LoadState.Loading
                    appendProgress.isVisible = it.source.append is LoadState.Loading
                    prependProgress.isVisible = it.source.prepend is LoadState.Loading
                }
            }
        }
    }
}