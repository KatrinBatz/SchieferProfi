package com.example.schieferprofi.data.model

import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

@Serializable
data class Deckung(
    @Json(name = "_id")

    val id: String,
    val name: String,
    val beschreibung: String,
    val bildUrl: String,
    val verwendung: List<String>,
    val schwierigkeitsgrad: String,
)