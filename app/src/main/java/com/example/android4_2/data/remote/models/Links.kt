package com.example.android4_2.data.remote.models

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("first")
    val first: String,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("last")
    val last: String
)