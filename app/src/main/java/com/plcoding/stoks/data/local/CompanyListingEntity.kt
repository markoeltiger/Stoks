package com.plcoding.stoks.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CompanyListingEntity(
    val name: String,
    val symbol: String,
    val exchange: String,
     val isFav:Boolean?=null,

    @PrimaryKey val id: Int? = null
)
