package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class KettengebindeInfo(
    val beschreibung: String = "",
    val ausfuehrungen: List<Ausfuehrung> = emptyList()
)

@Serializable
data class Ausfuehrung(
    val bezeichnung: String = "",
    val sondersteine: List<Sonderstein> = emptyList()
)

@Serializable
data class Sonderstein(
    val breite: Double = 0.0,
    val hoehe: Double? = null,
    val anzahl: Int? = null
)