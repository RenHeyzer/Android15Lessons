package com.geeks.pokeapiandroid15.data.remote.models

import com.google.gson.annotations.SerializedName

data class PokemonResponseDTO<T>(

    @SerializedName("count")
    val count: Int,

    @SerializedName("next")
    val next: String? = null,

    @SerializedName("previous")
    val previous: String? = null,

    @SerializedName("results")
    val results: List<T>
)