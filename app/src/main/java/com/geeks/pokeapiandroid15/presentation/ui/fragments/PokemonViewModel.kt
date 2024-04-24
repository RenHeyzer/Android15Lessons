package com.geeks.pokeapiandroid15.presentation.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.geeks.pokeapiandroid15.data.repositories.PokemonRepository
import com.geeks.pokeapiandroid15.presentation.models.PokemonUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private fun fetchPokemon() = repository.fetchPokemon().cachedIn(viewModelScope)

    val pokemonLiveData: LiveData<PagingData<PokemonUI>> = MediatorLiveData<PagingData<PokemonUI>>().apply {
        addSource(fetchPokemon()) {
            value = it
        }
    }

    init {
    }
}
