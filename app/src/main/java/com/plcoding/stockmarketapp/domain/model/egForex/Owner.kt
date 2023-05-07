package com.plcoding.stockmarketapp.domain.model.egForex


import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("name")
    val name: String?,
    @SerializedName("percentage")
    val percentage: String?
)