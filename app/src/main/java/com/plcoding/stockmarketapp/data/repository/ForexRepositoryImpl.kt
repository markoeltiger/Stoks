package com.plcoding.stockmarketapp.data.repository

import android.util.Log
import com.google.gson.Gson
import com.plcoding.stockmarketapp.data.csv.CSVParser
import com.plcoding.stockmarketapp.data.mapper.toCompanyInfo
import com.plcoding.stockmarketapp.data.remote.MubashirApi
import com.plcoding.stockmarketapp.domain.model.CompanyInfo
import com.plcoding.stockmarketapp.domain.model.CompanyListing
import com.plcoding.stockmarketapp.domain.model.egForex.ForexInfo
import com.plcoding.stockmarketapp.domain.model.egForex.ForexListing
import com.plcoding.stockmarketapp.domain.model.egForex.Row
import com.plcoding.stockmarketapp.domain.repository.ForexRepository
import com.plcoding.stockmarketapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ForexRepositoryImpl @Inject constructor(
    private val api: MubashirApi,
    private val companyListingsParser: CSVParser<CompanyListing>,


    ): ForexRepository {

    override fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<Row>>> {
        return flow<Resource<List<Row>>> {
            emit(Resource.Loading(true))


            val remoteListings = try {
                val respo = api.getEgListings()

                Log.e("remoteListings", respo.rows?.size.toString())
//                companyListingsParser.parse(respo.byteStream())
//
//                val response = api.getEgListings().data?.rows
                emit(Resource.Success(data = respo.rows as List<Row>?))


            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }

            remoteListings?.let { listings ->

//                    data = dao
//                        .searchCompanyListing("")
//                        .map { it.toCompanyListing()
//
            }

            emit(Resource.Loading(false))
        }
    }

    override suspend fun getCompanyInfo(
        fetchFromRemote: Boolean,
        symbol: String
    ): Flow<Resource<ForexInfo>> {


        return flow<Resource<ForexInfo>> {
            emit(Resource.Loading(true))

Log.e("getcompanyinfo","caaled")
            val remoteListings = try {
                val respo = api.getForexInfo(symbol)

//                val gson = Gson()
//                val responseResult: ForexListing =
//                    gson.fromJson(respo.byteString().toString(), ForexListing::class.java)
                Log.e("remoteListings", respo.establishedAt.toString())
//                companyListingsParser.parse(respo.byteStream())
//
//                val response = api.getEgListings().data?.rows
                emit(Resource.Success(data = respo))


            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }

            remoteListings?.let { listings ->

//                    data = dao
//                        .searchCompanyListing("")
//                        .map { it.toCompanyListing()
//
            }

            emit(Resource.Loading(false))
        }

     }

}




//    }
