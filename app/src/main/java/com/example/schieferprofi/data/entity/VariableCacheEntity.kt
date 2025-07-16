package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "variable_cache")
data class VariableCacheEntity(
    @PrimaryKey val id: String = "variable",
    val jsonData: String,
    val lastUpdated: Long
) 