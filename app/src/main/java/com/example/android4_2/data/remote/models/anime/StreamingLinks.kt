package com.example.android4_2.data.remote.models.anime

import com.google.gson.annotations.SerializedName

data class StreamingLinks(
    @SerializedName("links")
    val links: LinksX
)