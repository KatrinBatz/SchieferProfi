package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kettengebinde_cache")
data class KettengebindeCacheEntity(
    @PrimaryKey val id: String = "kettengebinde",
    val jsonData: String,
    val lastUpdated: Long
) 