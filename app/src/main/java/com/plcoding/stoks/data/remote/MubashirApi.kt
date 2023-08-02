package com.plcoding.stoks.data.remote

import com.plcoding.stoks.data.remote.dto.CompanyInfoDto
import com.plcoding.stoks.domain.model.egForex.ForexInfo
import com.plcoding.stoks.domain.model.egForex.ForexListing
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MubashirApi {

    @GET("/api/1/listed-companies?country=eg&size=500&start=0")
    suspend fun getEgListings(

    ): ForexListing

    @GET("/api/1/markets/EGX/stocks/{symbol}/profile")
    suspend fun getForexInfo(
        @Path("symbol") symbol: String,

    ): ForexInfo

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