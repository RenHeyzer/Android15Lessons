package com.geeks.pokeapiandroid15.data.remote

import com.geeks.pokeapiandroid15.data.remote.apiservises.PokemonApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://pokeapi.co/api/v2/"

class RetrofitClient {

    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
        )
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun pokemonApiService(): PokemonApiService {
        return retrofitClient.create(PokemonApiService::class.java)
    }
}