package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "unterlegte_cache")
data class UnterlegteCacheEntity(
    @PrimaryKey val id: String = "unterlegte",
    val jsonData: String,
    val lastUpdated: Long
) 