package com.example.android4_2.data.remote.models.manga

import com.example.android4_2.data.remote.models.anime.RatingFrequencies
import com.google.gson.annotations.SerializedName

data class Attributes(@SerializedName("endDate")
                      val endDate: String,
                      @SerializedName("ratingRank")
                      val ratingRank: Int = 0,
                      @SerializedName("posterImage")
                      val posterImage: PosterImage,
                      @SerializedName("createdAt")
                      val createdAt: String = "",
                      @SerializedName("subtype")
                      val subtype: String = "",
                      @SerializedName("averageRating")
                      val averageRating: String = "",
                      @SerializedName("coverImage")
                      val coverImage: CoverImage,
                      @SerializedName("ratingFrequencies")
                      val ratingFrequencies: RatingFrequencies,
                      @SerializedName("volumeCount")
                      val volumeCount: Int = 0,
                      @SerializedName("abbreviatedTitles")
                      val abbreviatedTitles:String,
                      @SerializedName("slug")
                      val slug: String = "",
                      @SerializedName("updatedAt")
                      val updatedAt: String = "",
                      @SerializedName("chapterCount")
                      val chapterCount: String,
                      @SerializedName("mangaType")
                      val mangaType: String = "",
                      @SerializedName("synopsis")
                      val synopsis: String = "",
                      @SerializedName("titles")
                      val titles: Titles,
                      @SerializedName("ageRating")
                      val ageRating: String = "",
                      @SerializedName("favoritesCount")
                      val favoritesCount: Int = 0,
                      @SerializedName("serialization")
                      val serialization: String = "",
                      @SerializedName("coverImageTopOffset")
                      val coverImageTopOffset: Int = 0,
                      @SerializedName("canonicalTitle")
                      val canonicalTitle: String = "",
                      @SerializedName("tba")
                      val tba: String = "",
                      @SerializedName("userCount")
                      val userCount: Int = 0,
                      @SerializedName("popularityRank")
                      val popularityRank: Int = 0,
                      @SerializedName("ageRatingGuide")
                      val ageRatingGuide: String = "",
                      @SerializedName("startDate")
                      val startDate: String = "",
                      @SerializedName("status")
                      val status: String = "")