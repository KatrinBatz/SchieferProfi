package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class GeschlaufteDeckungInfo(
    val beschreibung: String = "",
    val deckunterlage: String = "",
    val deckbild: String = "",
    val materialverweis: String = ""
)