package com.geeks.compose.ui.viewmodels

import com.geeks.compose.data.remote.dtos.Character
import com.geeks.compose.data.repositories.CharactersRepository
import com.geeks.compose.utils.base.BaseViewModel
import com.geeks.compose.utils.extensions.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : BaseViewModel() {

    private val _charactersState = uiStateLiveData<List<Character>>()
    val charactersState = _charactersState.asLiveData()

    init {
        charactersRepository.fetchCharacters().collectFlowAsState(
            _charactersState
        )
    }
}