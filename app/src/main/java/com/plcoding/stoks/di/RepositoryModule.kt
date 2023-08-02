package com.plcoding.stoks.di

import com.plcoding.stoks.data.csv.CSVParser
import com.plcoding.stoks.data.csv.CompanyListingsParser
import com.plcoding.stoks.data.csv.IntradayInfoParser
import com.plcoding.stoks.data.repository.ForexRepositoryImpl
import com.plcoding.stoks.data.repository.StockRepositoryImpl
import com.plcoding.stoks.domain.model.CompanyListing
import com.plcoding.stoks.domain.model.IntradayInfo
import com.plcoding.stoks.domain.repository.ForexRepository
import com.plcoding.stoks.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfoParser
    ): CSVParser<IntradayInfo>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
    @Binds
    @Singleton
    abstract fun bindForexRepository(
forexRepositoryImpl: ForexRepositoryImpl
    ): ForexRepository
}