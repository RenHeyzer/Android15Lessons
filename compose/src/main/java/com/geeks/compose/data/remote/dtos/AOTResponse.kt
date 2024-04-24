package com.geeks.compose.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class AOTResponse<T>(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<T>
)

data class Info(
    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next_page")
    val next: String? = null,
    @SerializedName("prev_page")
    val prev: String? = null
)