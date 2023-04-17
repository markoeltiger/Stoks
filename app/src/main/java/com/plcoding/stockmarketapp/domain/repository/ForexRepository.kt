package com.plcoding.stockmarketapp.domain.repository

import com.plcoding.stockmarketapp.domain.model.egForex.Row
import com.plcoding.stockmarketapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface ForexRepository   {

           fun getCompanyListings(
          fetchFromRemote: Boolean,
          query: String
    ):  Flow<Resource<List<Row>>>

}