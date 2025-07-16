package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deckung")
data class DeckungEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val beschreibung: String,
    val bildUrl: String,
    val verwendung: List<String>,
    val schwierigkeitsgrad: String,
    val lastUpdated: Long
)