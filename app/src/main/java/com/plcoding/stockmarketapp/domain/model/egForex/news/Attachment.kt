package com.plcoding.stockmarketapp.domain.model.egForex.news


import com.google.gson.annotations.SerializedName

data class Attachment(
    @SerializedName("key")
    val key: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)