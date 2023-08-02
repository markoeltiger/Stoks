package com.plcoding.stoks.domain.model.egForex


import com.google.gson.annotations.SerializedName

data class PriceBar(
    @SerializedName("change")
    val change: String?,
    @SerializedName("changePercentage")
    val changePercentage: String?,
    @SerializedName("close")
    val close: String?,
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("high")
    val high: String?,
    @SerializedName("historicalHigh")
    val historicalHigh: String?,
    @SerializedName("historicalLow")
    val historicalLow: String?,
    @SerializedName("low")
    val low: String?,
    @SerializedName("open")
    val `open`: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("turnover")
    val turnover: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?,
    @SerializedName("value")
    val value: String?,
    @SerializedName("volume")
    val volume: String?
)