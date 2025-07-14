package com.example.schieferprofi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoriten_deckart")
data class FavoritenDeckart(
    @PrimaryKey
    val idDeckart: String = "",
    val deckartName: String = "",
    val deckartBeschreibung: String = "",
    val deckartBild: String = ""
)