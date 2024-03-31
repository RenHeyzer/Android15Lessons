package com.example.android4_2.data.remote.models

import com.google.gson.annotations.SerializedName

data class DataItem(
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("links")
    val links: LinksSelf,
    @SerializedName("attributes")
    val attributes: Attributes,
)

data class LinksSelf(
    @SerializedName("self")
    val self: String
)