package com.plcoding.stoks.domain.model.egForex.news


import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("archived")
    val archived: Boolean?,
    @SerializedName("attachments")
    val attachments: Any?,
    @SerializedName("body")
    val body: String?,
    @SerializedName("categories")
    val categories: String?,
    @SerializedName("commentsLang")
    val commentsLang: Any?,
    @SerializedName("contentTitle")
    val contentTitle: Any?,
    @SerializedName("country")
    val country: Country?,
    @SerializedName("countryCodes")
    val countryCodes: String?,
    @SerializedName("disqusId")
    val disqusId: String?,
    @SerializedName("dynamicDescriptionTag")
    val dynamicDescriptionTag: Any?,
    @SerializedName("exclusiveLocked")
    val exclusiveLocked: Boolean?,
    @SerializedName("facebookDataHref")
    val facebookDataHref: Any?,
    @SerializedName("icon")
    val icon: Any?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: Image?,
    @SerializedName("infoMainTag")
    val infoMainTag: Any?,
    @SerializedName("infoMainTagData")
    val infoMainTagData: Any?,
    @SerializedName("infoMainTagUrl")
    val infoMainTagUrl: Any?,
    @SerializedName("infoSubTag")
    val infoSubTag: Any?,
    @SerializedName("infoSubTagUrl")
    val infoSubTagUrl: Any?,
    @SerializedName("infoSubTags")
    val infoSubTags: Any?,
    @SerializedName("lockedEndTime")
    val lockedEndTime: Any?,
    @SerializedName("miscImageUrl")
    val miscImageUrl: Any?,
    @SerializedName("numberOfReads")
    val numberOfReads: Int?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("removeCountryNameFromTitle")
    val removeCountryNameFromTitle: Boolean?,
    @SerializedName("section")
    val section: Section?,
    @SerializedName("sectionUrl")
    val sectionUrl: String?,
    @SerializedName("sections")
    val sections: Any?,
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