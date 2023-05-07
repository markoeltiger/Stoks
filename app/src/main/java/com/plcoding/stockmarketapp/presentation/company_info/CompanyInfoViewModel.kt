package com.plcoding.stockmarketapp.presentation.company_info

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.stockmarketapp.domain.model.CompanyInfo
import com.plcoding.stockmarketapp.domain.model.egForex.ForexInfo
import com.plcoding.stockmarketapp.domain.repository.ForexRepository
import com.plcoding.stockmarketapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyInfoViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: ForexRepository
): ViewModel() {

    var state by mutableStateOf(CompanyInfoState())

    init {
        viewModelScope.launch {
            val symbol = savedStateHandle.get<String>("symbol") ?: return@launch
            state = state.copy(isLoading = true)
            val companyInfoResult = async { repository.getCompanyInfo(true,symbol) }
            Log.e("mark",companyInfoResult.await().toString())
       val intradayInfoResult = async { repository.getCompanyInfo(true,symbol) }
            repository.getCompanyInfo(true,symbol).collect{
                when(it) {
                    is Resource.Success -> {
                        state = state.copy(
                            company = it.data as ForexInfo?,
                            isLoading = false,
                            error = null
                        )

                    }
                    is Resource.Error -> Unit
                    is Resource.Loading -> {
                        state = state.copy(isLoading = it.isLoading)
                    }
                }
            }
            when(val result = companyInfoResult.await()) {

                is Resource.Success<*> -> {
                    Log.e("tesrt","success")

                    state = state.copy(
                        company = result.data as ForexInfo?,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error<*> -> {
                    Log.e("tesrt","error"+result.message)

                    state = state.copy(
                        isLoading = false,
                        error = result.message,
                        company = null
                    )
                }
                else -> Unit
            }

        }
    }
}