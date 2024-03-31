package com.example.android4_2.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.android4_2.data.paging.source.AnimePagingSource
import com.example.android4_2.data.paging.source.MangaPagingSource
import com.example.android4_2.data.remote.apiservices.KitsuApiService
import com.example.android4_2.data.remote.models.DataItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class KitsuRepository @Inject constructor(
    private val kitsuApiService: KitsuApiService
) {
    fun fetchAnime(): LiveData<PagingData<DataItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { AnimePagingSource(kitsuApiService) }
        ).liveData
    }

    fun fetchManga(): Flow<PagingData<DataItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { MangaPagingSource(kitsuApiService) }
        ).flow
    }
}