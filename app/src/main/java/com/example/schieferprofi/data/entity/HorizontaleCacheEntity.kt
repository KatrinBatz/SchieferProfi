package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "horizontale_cache")
data class HorizontaleCacheEntity(
    @PrimaryKey val id: String = "horizontale",
    val jsonData: String,
    val lastUpdated: Long
) 