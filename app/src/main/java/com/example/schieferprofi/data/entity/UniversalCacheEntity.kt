package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "universal_cache")
data class UniversalCacheEntity(
    @PrimaryKey val id: String = "universal",
    val jsonData: String,
    val lastUpdated: Long
) 