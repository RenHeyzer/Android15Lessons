package com.geeks.compose.data.remote.dtos

import com.geeks.compose.domain.entities.Character
import com.google.gson.annotations.SerializedName

data class CharacterDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("img")
    val img: String
)

fun CharacterDTO.toDomain() = Character(
    id = id,
    name = name,
    img = img
)