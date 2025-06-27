package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SpezialFischschuppeDeckungInfo(
    val beschreibung: String = "",
    val decksteinmodell: String = "",
    val deckunterlage: String = "",
    val befestigung: FischschuppeBefestigung = FischschuppeBefestigung(),
    val ueberdeckungHinweis: String = "",
    val mindesthoehenueberdeckung: Int = 0,
    val ortUndFirstHinweis: String = "",
    val steinformatTabelle: List<FischschuppenFormat> = emptyList(),
    val materialbedarfHinweis: String = ""
)

@Serializable
data class FischschuppeBefestigung(
    val allgemein: String = "",
    val ausnahme: String = ""
)

@Serializable
data class FischschuppenFormat(
    val breite: Int = 0,
    val hoehe: Int = 0,
    val schnürrabstand: Double = 0.0,
    val schieferbedarfProM2: Double = 0.0,
    val gewichtPro1000: Int = 0,
    val stueckProKiste: Int = 0
)