package com.geeks.pokeapiandroid15.data.remote.models

import com.geeks.pokeapiandroid15.presentation.models.PokemonUI
import com.google.gson.annotations.SerializedName

data class PokemonDTO(

    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String,
)

fun PokemonDTO.toUI() = PokemonUI(
    id = url.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/", "")
        .toInt(),
    name = name,
    url = url
)