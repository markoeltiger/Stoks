package com.plcoding.stoks.domain.repository

import com.plcoding.stoks.domain.model.CompanyInfo
import com.plcoding.stoks.domain.model.CompanyListing
import com.plcoding.stoks.domain.model.IntradayInfo
import com.plcoding.stoks.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

    suspend fun getIntradayInfo(
        symbol: String
    ): Resource<List<IntradayInfo>>

    suspend fun getCompanyInfo(
        symbol: String
    ): Resource<CompanyInfo>
    suspend fun setFav(
        symbol: String
    )
}