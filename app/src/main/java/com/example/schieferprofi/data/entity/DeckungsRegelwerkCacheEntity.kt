package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deckungs_regelwerk_cache")
data class DeckungsRegelwerkCacheEntity(
    @PrimaryKey val id: String,
    val jsonData: String,
    val lastUpdated: Long
) 