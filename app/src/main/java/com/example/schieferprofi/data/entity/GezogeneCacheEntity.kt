package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gezogene_cache")
data class GezogeneCacheEntity(
    @PrimaryKey val id: String = "gezogene",
    val jsonData: String,
    val lastUpdated: Long
) 