package com.example.android4_2.ui.fragments.anime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.android4_2.data.remote.models.DataItem
import com.example.android4_2.data.repositories.KitsuFlowRepository
import com.example.android4_2.data.repositories.KitsuRepository
import com.example.android4_2.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
//    private val repositories: KitsuRepository
    private val repository: KitsuFlowRepository,
) : ViewModel() {

    private val _animeState = MutableStateFlow<UIState<List<DataItem>>>(UIState.Loading)
    val animeState = _animeState.asStateFlow()

//    private fun fetchAnime() = repositories.fetchAnime().cachedIn(viewModelScope)

//    val animeLiveData: LiveData<PagingData<DataItem>> = MediatorLiveData<PagingData<DataItem>>().apply {
//        addSource(fetchAnime()) {
//            value = it
//        }
//    }

    init {
        viewModelScope.launch {
            repository.fetchAnime().catch {
                val message = it.message ?: "Uknown error!"
                _animeState.value = UIState.Error(message = message, throwable = it)
            }.collect { anime ->
                _animeState.value = UIState.Success(anime)
            }
        }
    }
}