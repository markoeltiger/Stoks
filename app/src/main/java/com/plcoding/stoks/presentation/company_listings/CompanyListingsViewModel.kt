package com.plcoding.stoks.presentation.company_listings

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.stoks.data.remote.MubashirApi
import com.plcoding.stoks.domain.model.CompanyListing
import com.plcoding.stoks.domain.repository.ForexRepository
import com.plcoding.stoks.domain.repository.StockRepository
import com.plcoding.stoks.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CompanyListingsViewModel @Inject constructor(
    private val repository: StockRepository,
    private val forexRepo: ForexRepository,

    private val mubashirApi: MubashirApi

) : ViewModel() {

    var state by mutableStateOf(CompanyListingsState())

    private var searchJob: Job? = null

    init {
        getCompanyListings()
        getUSDRate()
    }

    fun onEvent(event: CompanyListingsEvent) {
        when (event) {
            is CompanyListingsEvent.Refresh -> {
                getCompanyListings(fetchFromRemote = true)
            }

            is CompanyListingsEvent.OnSearchQueryChange -> {
                getCompanyListings(fetchFromRemote = true, query = event.query)
                state = state.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L)
                    getCompanyListings()
                }
            }
        }
    }

    fun setFavorite(symbol: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.setFav(symbol)
        }
    }

    private fun getUSDRate() {
        viewModelScope.launch(Dispatchers.IO) {

            val document: Document =
                Jsoup.connect("https://www.mubasher.info/countries/eg")
                    .get()
            var usdRate =
                document.select("span.mi-important-links__text3").get(4).text().split(" ").last()
            state = state.copy(usdRate = usdRate)
            var goldRate =
                document.select("span.mi-important-links__text3").get(2).text().split(" ").last()
            state = state.copy(goldRate = goldRate)

        }
    }

    private fun getCompanyListings(
        query: String = state.searchQuery.lowercase(),
        fetchFromRemote: Boolean = false
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val document: Document =
                    Jsoup.connect("https://www.mubasher.info/countries/eg/companies")
                        .get()
                var words = document.select("span.mi-important-links__text3")

            } catch (e: IOException) {
                e.printStackTrace()

            }

            forexRepo.getCompanyListings(true, query)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {

                            result.data?.let { listings ->

forexRepo.setCompanys( listings.map { CompanyListing(name = it.name!!, symbol = it.symbol!!, exchange = it.price.toString()!!) })
                                 if (query != null && query != "") {
                                    Log.e(
                                        "searchfirsttime", "searchfirsttimeq" +
                                                "${query}"
                                    )
                                    var mylist = listings.filter { it ->
                                        it.name?.contains(query)!!


                                    }
                                    state = state.copy(
                                        companies = mylist
                                    )

                                } else {
                                    state = state.copy(
                                        companies = listings
                                    )
                                }


                            }
                        }

                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }
}