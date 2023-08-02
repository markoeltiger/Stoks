package com.plcoding.stoks.presentation.company_info

import com.plcoding.stoks.domain.model.IntradayInfo
import com.plcoding.stoks.domain.model.egForex.ForexInfo

data class CompanyInfoState(
    val stockInfos: List<IntradayInfo> = emptyList(),
    val company: ForexInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
