package com.plcoding.stoks.data.mapper

import com.plcoding.stoks.data.local.CompanyListingEntity
import com.plcoding.stoks.data.remote.dto.CompanyInfoDto
import com.plcoding.stoks.domain.model.CompanyInfo
import com.plcoding.stoks.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange

    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )
}