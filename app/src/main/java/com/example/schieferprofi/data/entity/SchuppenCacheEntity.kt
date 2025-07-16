package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schuppen_cache")
data class SchuppenCacheEntity(
    @PrimaryKey val id: String = "schuppen",
    val jsonData: String,
    val lastUpdated: Long
) 