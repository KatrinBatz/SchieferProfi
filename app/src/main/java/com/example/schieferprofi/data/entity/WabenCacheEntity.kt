package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "waben_cache")
data class WabenCacheEntity(
    @PrimaryKey val id: String = "waben",
    val jsonData: String,
    val lastUpdated: Long
) 