package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "altdeutsche_cache")
data class AltdeutscheCacheEntity(
    @PrimaryKey val id: String = "altdeutsche",
    val jsonData: String,
    val lastUpdated: Long
) 