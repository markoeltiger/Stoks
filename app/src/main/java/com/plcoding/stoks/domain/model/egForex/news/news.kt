package com.plcoding.stoks.domain.model.egForex.news


import com.google.gson.annotations.SerializedName

data class news(
    @SerializedName("announcements")
    val announcements: List<Announcement?>?,
    @SerializedName("articles")
    val articles: List<Article?>?,
    @SerializedName("capital")
    val capital: String?,
    @SerializedName("companyTab")
    val companyTab: CompanyTab?,
    @SerializedName("events")
    val events: List<Any?>?,
    @SerializedName("initialShares")
    val initialShares: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("sector")
    val sector: String?,
    @SerializedName("shares")
    val shares: String?,
    @SerializedName("stockStatistics")
    val stockStatistics: StockStatistics?,
    @SerializedName("stocks")
    val stocks: List<String?>?,
    @SerializedName("tradingName")
    val tradingName: String?
)