package com.geeks.compose.presentation.ui.viewmodels

import com.geeks.compose.domain.entities.Character
import com.geeks.compose.domain.repositories.CharactersRepository
import com.geeks.compose.domain.usecases.FetchFilterCharactersUseCase
import com.geeks.compose.utils.base.BaseViewModel
import com.geeks.compose.utils.extensions.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val fetchFilterCharactersUseCase: FetchFilterCharactersUseCase,
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