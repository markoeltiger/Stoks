package com.plcoding.stockmarketapp.domain.model.egForex


import com.google.gson.annotations.SerializedName

data class ForexInfo(
    @SerializedName("auditors")
    val auditors: List<String?>?,
    @SerializedName("companyTab")
    val companyTab: CompanyTab?,
    @SerializedName("contacts")
    val contacts: Contacts?,
    @SerializedName("establishedAt")
    val establishedAt: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("investorRelationsUrl")
    val investorRelationsUrl: Any?,
    @SerializedName("managementMembers")
    val managementMembers: List<ManagementMember?>?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("owners")
    val owners: List<Owner?>?,
    @SerializedName("purpose")
    val purpose: String?,
    @SerializedName("subsidiaries")
    val subsidiaries: List<Subsidiary?>?,
    @SerializedName("yearStart")
    val yearStart: String?
)