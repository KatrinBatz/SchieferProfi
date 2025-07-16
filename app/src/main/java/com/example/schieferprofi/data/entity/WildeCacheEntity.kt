package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wilde_cache")
data class WildeCacheEntity(
    @PrimaryKey val id: String = "wilde",
    val jsonData: String,
    val lastUpdated: Long
) 