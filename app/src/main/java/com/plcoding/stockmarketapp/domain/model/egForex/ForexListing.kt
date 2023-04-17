package com.plcoding.stockmarketapp.domain.model.egForex


import com.google.gson.annotations.SerializedName

data class ForexListing(
    @SerializedName("numberOfPages")
    val numberOfPages: Int?,
    @SerializedName("rows")
    val rows: List<Row?>?,
    @SerializedName("validCriteria")
    val validCriteria: Boolean?
)