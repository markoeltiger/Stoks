package com.plcoding.stockmarketapp.presentation.company_listings

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.stockmarketapp.data.remote.MubashirApi
import com.plcoding.stockmarketapp.domain.repository.ForexRepository
import com.plcoding.stockmarketapp.domain.repository.StockRepository
import com.plcoding.stockmarketapp.util.Resource
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

): ViewModel() {

    var state by mutableStateOf(CompanyListingsState())

    private var searchJob: Job? = null

    init {
        getCompanyListings()
    }

    fun onEvent(event: CompanyListingsEvent) {
        when(event) {
            is CompanyListingsEvent.Refresh -> {
                getCompanyListings(fetchFromRemote = true)
            }
            is CompanyListingsEvent.OnSearchQueryChange -> {
                state = state.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L)
                    getCompanyListings()
                }
            }
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
               var words = document.select("global__no-results ng-hide").text()
                Log.e("words",words.toString())
            } catch (e: IOException) {
                e.printStackTrace()

            }

             forexRepo.getCompanyListings(true,"" )
                .collect { result ->
                    when(result) {
                        is Resource.Success -> {
                            result.data?.let { listings ->
                                state = state.copy(
                                    companies = listings
                                )
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