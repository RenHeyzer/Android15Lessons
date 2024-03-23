package com.example.android4_2.data.remote.models.manga

import com.google.gson.annotations.SerializedName

data class MangaResponse(@SerializedName("data")
                         val data: List<DataItem>,
                         @SerializedName("meta")
                         val meta: Meta,
                         @SerializedName("links")
                         val links: Links)