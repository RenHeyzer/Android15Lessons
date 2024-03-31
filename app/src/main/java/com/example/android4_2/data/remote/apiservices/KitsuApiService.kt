package com.example.android4_2.data.remote.apiservices

import com.example.android4_2.data.remote.models.KitsuResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val ANIME_END_POINT = "anime/"
private const val MANGA_ENP_POINT = "manga/"

interface KitsuApiService {

    @GET(ANIME_END_POINT)
    suspend fun getAnime(
        @Query("page[offset]") offset: Int,
        @Query("page[limit]") limit: Int
    ): KitsuResponse

    @GET(MANGA_ENP_POINT)
    suspend fun getManga(
        @Query("page[offset]") offset: Int,
        @Query("page[limit]") limit: Int
    ): KitsuResponse
}