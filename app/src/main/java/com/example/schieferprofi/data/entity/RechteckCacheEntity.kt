package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rechteck_cache")
data class RechteckCacheEntity(
    @PrimaryKey val id: String = "rechteck",
    val jsonData: String,
    val lastUpdated: Long
) 