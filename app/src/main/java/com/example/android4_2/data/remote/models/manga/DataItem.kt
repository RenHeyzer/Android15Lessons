package com.example.android4_2.data.remote.models.manga

import com.google.gson.annotations.SerializedName

data class DataItem(@SerializedName("relationships")
                    val relationships: Relationships,
                    @SerializedName("links")
                    val links: Links,
                    @SerializedName("attributes")
                    val attributes: Attributes,
                    @SerializedName("id")
                    val id: String = "",
                    @SerializedName("type")
                    val type: String = "")