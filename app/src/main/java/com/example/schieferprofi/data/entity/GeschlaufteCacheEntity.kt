package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "geschlaufte_cache")
data class GeschlaufteCacheEntity(
    @PrimaryKey val id: String = "geschlaufte",
    val jsonData: String,
    val lastUpdated: Long
) 