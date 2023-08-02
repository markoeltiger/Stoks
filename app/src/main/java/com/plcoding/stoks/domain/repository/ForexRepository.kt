package com.plcoding.stoks.domain.repository

import com.plcoding.stoks.domain.model.CompanyListing
import com.plcoding.stoks.domain.model.egForex.ForexInfo
import com.plcoding.stoks.domain.model.egForex.Row
import com.plcoding.stoks.util.Resource
import kotlinx.coroutines.flow.Flow

interface ForexRepository {
fun setCompanys(
    companies:List<CompanyListing>
)

    fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<Row>>>

    suspend fun getCompanyInfo(
        fetchFromRemote: Boolean,
        symbol: String
    ): Flow<Resource<ForexInfo>>


}