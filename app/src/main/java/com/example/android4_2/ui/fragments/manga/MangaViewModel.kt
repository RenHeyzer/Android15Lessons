package com.example.android4_2.ui.fragments.manga

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.android4_2.data.remote.models.DataItem
import com.example.android4_2.data.repositories.KitsuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val repositories: KitsuRepository
) : ViewModel() {

//    private val _mangaState = MutableLiveData<PagingData<DataItem>>()
//    val mangaState: LiveData<PagingData<DataItem>> = _mangaState

    private val _mangaState = MutableStateFlow(PagingData.empty<DataItem>())
    val mangaState = _mangaState.asStateFlow()

    init {
        viewModelScope.launch {
            repositories.fetchManga().cachedIn(viewModelScope).collectLatest {
                _mangaState.value = it
            }
        }
    }
}