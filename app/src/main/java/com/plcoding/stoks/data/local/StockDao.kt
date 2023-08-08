package com.plcoding.stoks.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StockDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompanyListings(
        companyListingEntities: List<CompanyListingEntity>
    )


    @Query("DELETE FROM companylistingentity")
    suspend fun clearCompanyListings()

    @Query("SELECT * FROM CompanyListingEntity WHERE isFav == 1")
    suspend fun getFavsCompanys(): List<CompanyListingEntity>

    @Query("UPDATE CompanyListingEntity SET isFav = 1 WHERE symbol == :symbol")
    suspend fun setFavCompany(symbol: String)

    @Query(
        """
            SELECT * 
            FROM companylistingentity
            WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' OR
                UPPER(:query) == symbol
        """
    )

    suspend fun searchCompanyListing(query: String): List<CompanyListingEntity>
}