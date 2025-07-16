package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spitzwinkel_cache")
data class SpitzwinkelCacheEntity(
    @PrimaryKey val id: String = "spitzwinkel",
    val jsonData: String,
    val lastUpdated: Long
) 