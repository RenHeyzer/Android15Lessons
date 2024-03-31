package com.example.android4_2.data.paging.source

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android4_2.data.remote.apiservices.KitsuApiService
import com.example.android4_2.data.remote.models.DataItem
import retrofit2.HttpException
import java.io.IOException

private const val START_OFFSET = 0

class MangaPagingSource(private val kitsuApiService: KitsuApiService) :
    PagingSource<Int, DataItem>() {

    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        val limit = params.loadSize
        val offset = params.key ?: START_OFFSET
        return try {
            val response = kitsuApiService.getManga(limit = limit, offset = offset)
            val nextOffset = if (response.links.next != null)
                Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()
            else null
            LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = nextOffset
            )

        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}