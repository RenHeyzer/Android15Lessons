package com.geeks.pokeapiandroid15.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import androidx.paging.map
import com.geeks.pokeapiandroid15.data.paging.source.PokemonPagingSource
import com.geeks.pokeapiandroid15.data.remote.apiservises.PokemonApiService
import com.geeks.pokeapiandroid15.data.remote.models.toUI
import com.geeks.pokeapiandroid15.presentation.models.PokemonUI
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonApiService: PokemonApiService,
) {

    fun fetchPokemon(): LiveData<PagingData<PokemonUI>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 40,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { PokemonPagingSource(pokemonApiService) }
        ).liveData.map { pagingData ->
            pagingData.map {
                it.toUI()
            }
        }
    }
}

