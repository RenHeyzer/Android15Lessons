package com.geeks.compose.data.repositories

import com.geeks.compose.data.remote.apiservices.CharactersApiService
import com.geeks.compose.utils.AppDispatchers
import com.geeks.compose.utils.base.BaseRepository
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val appDispatchers: AppDispatchers,
    private val charactersApiService: CharactersApiService,
) : BaseRepository(appDispatchers) {

    fun fetchCharacters() = doRequest {
        charactersApiService.fetchCharacters().results
    }
}