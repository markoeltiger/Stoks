package com.plcoding.stockmarketapp.domain.model.egForex


import com.google.gson.annotations.SerializedName

data class Row(
    @SerializedName("changePercentage")
    val changePercentage: Double?,
    @SerializedName("currency")
    val currency: Any?,
    @SerializedName("lastUpdate")
    val lastUpdate: String?,
    @SerializedName("market")
    val market: String?,
    @SerializedName("marketUrl")
    val marketUrl: Any?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("profileUrl")
    val profileUrl: String?,
    @SerializedName("sector")
    val sector: String?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("url")
    val url: String?
)