package com.example.android4_2.data.remote.models.anime

import com.google.gson.annotations.SerializedName

data class Small(
    @SerializedName("height")
    val height: Any,
    @SerializedName("width")
    val width: Any
)