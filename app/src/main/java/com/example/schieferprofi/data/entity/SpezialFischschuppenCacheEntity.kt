package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spezial_fischschuppen_cache")
data class SpezialFischschuppenCacheEntity(
    @PrimaryKey val id: String = "spezial_fischschuppen",
    val jsonData: String,
    val lastUpdated: Long
) 