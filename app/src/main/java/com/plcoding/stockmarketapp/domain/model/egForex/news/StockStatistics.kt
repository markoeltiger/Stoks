package com.plcoding.stockmarketapp.domain.model.egForex.news


import com.google.gson.annotations.SerializedName

data class StockStatistics(
    @SerializedName("assetsGrowth")
    val assetsGrowth: Any?,
    @SerializedName("book")
    val book: String?,
    @SerializedName("code")
    val code: String?,
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("currencySubunit")
    val currencySubunit: String?,
    @SerializedName("eps")
    val eps: String?,
    @SerializedName("exchange")
    val exchange: String?,
    @SerializedName("frlastUpdate")
    val frlastUpdate: String?,
    @SerializedName("frquarter")
    val frquarter: String?,
    @SerializedName("fryear")
    val fryear: String?,
    @SerializedName("marketCap")
    val marketCap: String?,
    @SerializedName("par")
    val par: String?,
    @SerializedName("pbRatio")
    val pbRatio: String?,
    @SerializedName("peRatio")
    val peRatio: String?
)