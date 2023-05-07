package com.plcoding.stockmarketapp.domain.model.egForex


import com.google.gson.annotations.SerializedName

data class Subsidiary(
    @SerializedName("name")
    val name: String?,
    @SerializedName("percentage")
    val percentage: String?
)