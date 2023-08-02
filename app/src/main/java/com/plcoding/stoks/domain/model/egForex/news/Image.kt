package com.plcoding.stoks.domain.model.egForex.news


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("alt")
    val alt: String?,
    @SerializedName("caption")
    val caption: String?,
    @SerializedName("largeThumbnail")
    val largeThumbnail: String?,
    @SerializedName("primary")
    val primary: String?,
    @SerializedName("smallThumbnail")
    val smallThumbnail: String?,
    @SerializedName("srcset")
    val srcset: String?
)