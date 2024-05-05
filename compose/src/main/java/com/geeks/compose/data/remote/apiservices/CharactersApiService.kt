package com.geeks.compose.data.remote.apiservices

import com.geeks.compose.data.remote.dtos.AOTResponse
import com.geeks.compose.data.remote.dtos.CharacterDTO
import retrofit2.http.GET

private const val END_POINT = "characters"

interface CharactersApiService {

    @GET(END_POINT)
    suspend fun fetchCharacters(): AOTResponse<CharacterDTO>
}