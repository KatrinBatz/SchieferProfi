package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class VariableDeckungInfo(
    val beschreibung: String = "",
    val deckunterlage: String = "",
    val befestigung: VariableBefestigung = VariableBefestigung(),
    val ueberdeckung: VariableUeberdeckung = VariableUeberdeckung(),
    val formate: List<VariableFormat> = emptyList(),
    val ortdeckungHinweis: String = "",
    val flaecheneinteilungHinweis: String = "",
    val schnuerabstandHinweis: String = "",
    val kombinierbareFormateHinweis: String = ""
)

@Serializable
data class VariableBefestigung(
    val alternativeBefestigungHinweis: String = ""
)

@Serializable
data class VariableUeberdeckung(
    val ueberdeckungHinweis: String = ""
)

@Serializable
data class VariableFormat(
    val format: String = "",
    val sichtbaresFormat: String = "",
    val schieferbedarfProM2: Double = 0.0,
    val schnuerabstand: Double = 0.0,
    val gewichtPro1000Stk: Int = 0
)