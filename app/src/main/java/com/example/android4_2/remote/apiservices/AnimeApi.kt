package com.example.android4_2.remote.apiservices

import com.example.android4_2.remote.models.AnimeResponse
import com.example.android4_2.remote.models.Data
import retrofit2.http.GET
import retrofit2.http.Query

private const val END_POINT = "https://kitsu.io/api/edge/anime"

interface AnimeApi {

    @GET(END_POINT)
    suspend fun getAnime(
        @Query("offset") offset: Int,
        @Query("limit") limit:Int
    ): AnimeResponse<Data>
}