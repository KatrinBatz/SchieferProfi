package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gebindesteigung_cache")
data class GebindesteigungCacheEntity(
    @PrimaryKey val id: String,
    val jsonData: String,
    val lastUpdated: Long
) 