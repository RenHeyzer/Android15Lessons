package com.example.android4_2.data.remote.apiservices

import com.example.android4_2.remote.models.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val END_POINT = "anime"

interface AnimeApi {

    @GET(END_POINT)
    suspend fun getAnime(
        @Query("page[offset]") offset: Int,
        @Query("page[limit]") limit: Int
    ): AnimeResponse
}