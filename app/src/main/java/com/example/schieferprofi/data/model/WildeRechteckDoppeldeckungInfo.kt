package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WildeRechteckDoppeldeckungInfo(
    val beschreibung: String = "",
    val deckbild: String = "",
    val deckunterlage: String = "",
    val befestigung: WildeBefestigung = WildeBefestigung(),
    val mindesthoehenueberdeckungHinweis: String = "",
    val mindestdachneigung: String = "",
    val steinformateHinweis: String = "",
    val besonderheiten: List<String> = emptyList()
)

@Serializable
data class WildeBefestigung(
    val dach: String = "",
    val ortGrat: String = ""
)