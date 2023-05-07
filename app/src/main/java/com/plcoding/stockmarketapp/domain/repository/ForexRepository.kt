package com.plcoding.stockmarketapp.domain.repository

import com.plcoding.stockmarketapp.domain.model.CompanyInfo
import com.plcoding.stockmarketapp.domain.model.egForex.ForexInfo
import com.plcoding.stockmarketapp.domain.model.egForex.Row
import com.plcoding.stockmarketapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface ForexRepository {

    fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<Row>>>

    suspend fun getCompanyInfo(
        fetchFromRemote: Boolean,
        symbol: String
    ): Flow<Resource<ForexInfo>>

}