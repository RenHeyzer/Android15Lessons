package com.example.android4_2.data.remote.models

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("slug")
    val slug: String,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("titles")
    val titles: Titles,
    @SerializedName("averageRating")
    val averageRating: String,
    @SerializedName("ratingRank")
    val ratingRank : Int,
    @SerializedName("ageRating")
    val ageRating : String,
    @SerializedName("subtype")
    val subtype : String,
    @SerializedName("status")
    val status : String,
    @SerializedName("posterImage")
    val posterImage : PosterImage,
)

data class Titles(
    @SerializedName("en")
    val en: String? = null,
    @SerializedName("en_jp")
    val enJp: String? = null,
    @SerializedName("en_us")
    val enUs: String? = null,
    @SerializedName("ja_jp")
    val jaJp: String? = null,
)

data class PosterImage(
    @SerializedName("large")
    val large: String,
    @SerializedName("medium")
    val medium: String,
    @SerializedName("original")
    val original: String,
)