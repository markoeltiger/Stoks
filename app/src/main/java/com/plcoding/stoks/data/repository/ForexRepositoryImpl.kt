package com.plcoding.stoks.data.repository

import android.util.Log
import com.plcoding.stoks.data.csv.CSVParser
import com.plcoding.stoks.data.local.CompanyListingEntity
import com.plcoding.stoks.data.local.StockDatabase
import com.plcoding.stoks.data.mapper.toCompanyListing
import com.plcoding.stoks.data.mapper.toCompanyListingEntity
import com.plcoding.stoks.data.remote.MubashirApi
import com.plcoding.stoks.domain.model.CompanyListing
import com.plcoding.stoks.domain.model.egForex.ForexInfo
import com.plcoding.stoks.domain.model.egForex.Row
import com.plcoding.stoks.domain.repository.ForexRepository
import com.plcoding.stoks.util.Resource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ForexRepositoryImpl @Inject constructor(
    private val api: MubashirApi,
    private val companyListingsParser: CSVParser<CompanyListing>,
    private val db: StockDatabase,


    ): ForexRepository {
    private val dao = db.dao
override fun setCompanys(comanys:List<CompanyListing>){
    GlobalScope.launch {
    dao.insertCompanyListings(
        comanys.map { CompanyListingEntity(name = it.name, exchange = it.exchange, symbol =it.symbol) }
    )
    }
}
    override fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<Row>>> {
        return flow<Resource<List<Row>>> {
            emit(Resource.Loading(true))


            val remoteListings = try {
                val respo = api.getEgListings()
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
                dao.clearCompanyListings()
                Log.e("SavedToDBForexRepo","SavedToDB")
         
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
