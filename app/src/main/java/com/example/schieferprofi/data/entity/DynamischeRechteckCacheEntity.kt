package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dynamische_rechteck_cache")
data class DynamischeRechteckCacheEntity(
    @PrimaryKey val id: String = "dynamische_rechteck",
    val jsonData: String,
    val lastUpdated: Long
) 