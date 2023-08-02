package com.plcoding.stoks.domain.model.egForex.news


import com.google.gson.annotations.SerializedName

data class CompanyTab(
    @SerializedName("index")
    val index: Int?,
    @SerializedName("market")
    val market: String?,
    @SerializedName("priceBar")
    val priceBar: PriceBar?,
    @SerializedName("stock")
    val stock: String?,
    @SerializedName("tabs")
    val tabs: List<String?>?,
    @SerializedName("title")
    val title: String?
)