package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "waagerechte_cache")
data class WaagerechteCacheEntity(
    @PrimaryKey val id: String = "waagerechte",
    val jsonData: String,
    val lastUpdated: Long
) 