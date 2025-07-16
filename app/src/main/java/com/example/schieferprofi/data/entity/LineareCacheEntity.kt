package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lineare_cache")
data class LineareCacheEntity(
    @PrimaryKey val id: String = "lineare",
    val jsonData: String,
    val lastUpdated: Long
) 