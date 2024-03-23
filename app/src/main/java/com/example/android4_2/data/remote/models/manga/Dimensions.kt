package com.example.android4_2.data.remote.models.manga

import com.google.gson.annotations.SerializedName

data class Dimensions(@SerializedName("small")
                      val small: Small,
                      @SerializedName("large")
                      val large: Large,
                      @SerializedName("tiny")
                      val tiny: Tiny)