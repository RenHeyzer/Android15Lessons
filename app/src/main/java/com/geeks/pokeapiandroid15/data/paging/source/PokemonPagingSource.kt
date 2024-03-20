package com.geeks.pokeapiandroid15.data.paging.source

import androidx.core.net.toUri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.geeks.pokeapiandroid15.data.remote.apiservises.PokemonApiService
import com.geeks.pokeapiandroid15.data.remote.models.PokemonDTO
import retrofit2.HttpException
import java.io.IOException

private const val START_KEY = 0

class PokemonPagingSource(
    private val pokemonApiService: PokemonApiService,
) : PagingSource<Int, PokemonDTO>() {

    override fun getRefreshKey(state: PagingState<Int, PokemonDTO>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonDTO> {
        return try {
            val offset = params.key ?: START_KEY
            val response = pokemonApiService.fetchPokemon(
                offset = offset,
                limit = params.loadSize
            )
            val nextKey = if (response.next != null) {
                response.next.toUri().getQueryParameter("offset")?.toInt()
            } else null

            LoadResult.Page(
                data = response.results,
                nextKey = nextKey,
                prevKey = null
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}