package com.plcoding.stoks.domain.model.egForex.news


import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("key")
    val key: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: Any?
)