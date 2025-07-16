package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gebindesteigung1_cache")
data class Gebindesteigung1CacheEntity(
    @PrimaryKey val id: String,
    val jsonData: String,
    val lastUpdated: Long
) 