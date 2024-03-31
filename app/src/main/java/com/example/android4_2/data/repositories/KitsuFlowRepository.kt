package com.example.android4_2.data.repositories

import com.example.android4_2.data.remote.apiservices.KitsuApiService
import com.example.android4_2.utils.CoroutineDispatchers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class KitsuFlowRepository @Inject constructor(
    private val kitsuApiService: KitsuApiService,
    private val dispatchers: CoroutineDispatchers
) {

    fun fetchAnime() = flow {
        val anime = kitsuApiService.getAnime(0, 20)
        emit(anime.data)
    }.flowOn(dispatchers.io)
}