package com.geeks.pokeapiandroid15.data.remote.apiservises

import com.geeks.pokeapiandroid15.data.remote.models.PokemonDTO
import com.geeks.pokeapiandroid15.data.remote.models.PokemonResponseDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val END_POINT = "pokemon"

interface PokemonApiService {

    @GET(END_POINT)
    suspend fun fetchPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): PokemonResponseDTO<PokemonDTO>
}