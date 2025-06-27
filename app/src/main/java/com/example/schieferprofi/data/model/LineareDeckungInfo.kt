package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LineareDeckungInfo(
    val beschreibung: String = "",
    val deckunterlage: String = "",
    val befestigungSicht: BefestigungSicht = BefestigungSicht(),
    val befestigungUnterlegt: BefestigungUnterlegt = BefestigungUnterlegt(),
    val ueberdeckung: UeberdeckungLineare = UeberdeckungLineare(),
    val formate: List<LinearesFormat> = emptyList(),
    val materialbedarfHinweis: String = ""
)

@Serializable
data class BefestigungSicht(
    val material: String = ""
)

@Serializable
data class BefestigungUnterlegt(
    val minGroesseFuerHaken: String = "",
    val blechHinweis: String = ""
)

@Serializable
data class UeberdeckungLineare(
    val stossfugeBreite: String = ""
)

@Serializable
data class LinearesFormat(
    val format: String = "",
    val schieferbedarfProM2: Double = 0.0,
    val hakenverbrauchProM2: Double = 0.0,
    val hakenlaenge: Int = 0,
    val lattenabstand: Double = 0.0,
    val lattenverbrauchProM2: Double = 0.0,
    val gewichtPro1000Stk: Int = 0
)