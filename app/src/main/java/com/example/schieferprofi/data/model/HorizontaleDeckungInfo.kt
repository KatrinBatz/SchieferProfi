package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class HorizontaleDeckungInfo(
    val beschreibung: String = "",
    val deckunterlage: String = "",
    val deckbild: String = "",
    val befestigung: String = "",
    val mindestHoehenueberdeckung: Int = 0,
    val vorteile: List<String> = emptyList(),
    val formate: List<HorizontaleFormat> = emptyList()
)

@Serializable
data class HorizontaleFormat(
    val format: String = "",
    val schieferbedarfProM2: Double = 0.0,
    val hakenverbrauchProM2: Double = 0.0,
    val lattenabstandCm: Double = 0.0,
    val lattenverbrauchProM2: Double = 0.0,
    val gewichtPro1000Stk: Int = 0
)