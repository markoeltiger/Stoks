package com.plcoding.stockmarketapp.data.remote

import com.plcoding.stockmarketapp.data.remote.dto.CompanyInfoDto
import com.plcoding.stockmarketapp.domain.model.egForex.ForexListing
import com.plcoding.stockmarketapp.util.Resource
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface MubashirApi {

    @GET("/api/1/listed-companies?country=eg&size=500&start=0")
suspend      fun getEgListings(

        ):ForexListing

    @GET("query?function=TIME_SERIES_INTRADAY&interval=60min&datatype=csv")
    suspend fun getIntradayInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = API_KEY
    ): ResponseBody

    @GET("query?function=OVERVIEW")
    suspend fun getCompanyInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = API_KEY
    ): CompanyInfoDto

    companion object {
        const val API_KEY = "G1USXWKX272RK4BP"
        const val BASE_URL = "https://alphavantage.co"
    }
}