package com.plcoding.stoks.domain.model.egForex


import com.google.gson.annotations.SerializedName

data class Contacts(
    @SerializedName("address")
    val address: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("fax")
    val fax: String?,
    @SerializedName("person")
    val person: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("website")
    val website: String?
)