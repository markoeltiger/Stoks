package com.plcoding.stockmarketapp.domain.model.egForex.news


import com.google.gson.annotations.SerializedName

data class Announcement(
    @SerializedName("attachments")
    val attachments: List<Attachment?>?,
    @SerializedName("body")
    val body: Any?,
    @SerializedName("disqusId")
    val disqusId: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("numberOfReads")
    val numberOfReads: Int?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("stocks")
    val stocks: Any?,
    @SerializedName("teaser")
    val teaser: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("updatedAt")
    val updatedAt: Any?,
    @SerializedName("url")
    val url: String?
)