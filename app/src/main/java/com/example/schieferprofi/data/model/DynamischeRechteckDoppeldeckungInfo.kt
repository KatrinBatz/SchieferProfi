package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class DynamischeRechteckDoppeldeckungInfo(
    val beschreibung: String = "",
    val deckunterlage: String = "",
    val befestigung: RechteckBefestigung = RechteckBefestigung(),
    val deckbild: String = "",
    val verlegeschema: String = "",
    val dachneigungHinweis: String = "",
    val hoehenueberdeckung: HoehenueberdeckungMap = HoehenueberdeckungMap(),
    val fugenversatz: Int = 0,
    val formate: List<DynamischeRechteckFormat> = emptyList()
)

@Serializable
data class RechteckBefestigung(
    val dach: String = "",
    val ortGrat: String = ""
)

@Serializable
data class BefestigungDynamischRechteck(
    @SerialName("≥ 40°") val ab40Grad: Int = 0,
    @SerialName("≥ 50°") val ab50Grad: Int = 0
)

@Serializable
data class DynamischeRechteckFormat(
    val steinhoehe: Int = 0,
    val gebindehoehe: List<Double> = emptyList(),
    val formate: List<String> = emptyList()
)