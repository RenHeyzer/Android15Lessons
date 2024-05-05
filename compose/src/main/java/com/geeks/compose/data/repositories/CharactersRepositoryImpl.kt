package com.geeks.compose.data.repositories

import com.geeks.compose.data.remote.apiservices.CharactersApiService
import com.geeks.compose.data.remote.dtos.toDomain
import com.geeks.compose.domain.repositories.CharactersRepository
import com.geeks.compose.utils.AppDispatchers
import com.geeks.compose.utils.base.BaseRepository
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val appDispatchers: AppDispatchers,
    private val charactersApiService: CharactersApiService,
) : BaseRepository(appDispatchers), CharactersRepository {

    override fun fetchCharacters() = doRequest {
        charactersApiService.fetchCharacters().results.map { dto ->
            dto.toDomain()
        }
    }
}