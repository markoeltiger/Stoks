package com.plcoding.stoks.domain.model.egForex


import com.google.gson.annotations.SerializedName

data class ManagementMember(
    @SerializedName("name")
    val name: String?,
    @SerializedName("represents")
    val represents: String?,
    @SerializedName("role")
    val role: String?
)