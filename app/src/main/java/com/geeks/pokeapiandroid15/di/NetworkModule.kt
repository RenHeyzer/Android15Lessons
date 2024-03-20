package com.geeks.pokeapiandroid15.di

import com.geeks.pokeapiandroid15.data.remote.RetrofitClient
import com.geeks.pokeapiandroid15.data.remote.apiservises.PokemonApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun providePokemonApiService() : PokemonApiService {
        return retrofitClient.pokemonApiService()
    }
}