package com.example.android4_2.ui.fragments.anime

import androidx.lifecycle.ViewModel
import com.example.android4_2.data.remote.repositories.AnimeRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repositories: AnimeRepositories
) : ViewModel() {
    fun fetchAnime() = repositories.fetchAnime()
}