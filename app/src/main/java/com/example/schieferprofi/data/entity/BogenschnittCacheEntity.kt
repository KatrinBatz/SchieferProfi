package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bogenschnitt_cache")
data class BogenschnittCacheEntity(
    @PrimaryKey val id: String = "bogenschnitt",
    val jsonData: String,
    val lastUpdated: Long
) 