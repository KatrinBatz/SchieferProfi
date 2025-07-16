package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dynamische_cache")
data class DynamischeCacheEntity(
    @PrimaryKey val id: String = "dynamische",
    val jsonData: String,
    val lastUpdated: Long
) 