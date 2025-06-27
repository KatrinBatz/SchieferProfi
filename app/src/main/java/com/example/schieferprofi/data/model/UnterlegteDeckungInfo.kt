package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UnterlegteDeckungInfo(
    val beschreibung: String = "",
    val deckunterlage: String = "",
    val befestigung: UnterlegteBefestigung = UnterlegteBefestigung(),
    val ueberdeckung: UnterlegteUeberdeckung = UnterlegteUeberdeckung(),
    val formate: List<UnterlegteFormat> = emptyList(),
    val flaecheneinteilungHinweis: String = "",
    val ortFirstHinweis: String = "",
    val deckbildHinweis: String = ""
)

@Serializable
data class UnterlegteBefestigung(
    val klammerTyp: String = ""
)

@Serializable
data class UnterlegteUeberdeckung(
    val schnuerabstandWaagrecht: String = "",
    val schnuerabstandSenkrecht: String = ""
)

@Serializable
data class UnterlegteFormat(
    val format: String = "",
    val schieferbedarfProM2: Double = 0.0,
    val hakenverbrauchProM2: Double = 0.0,
    val lattenabstand: Double = 0.0,
    val lattenverbrauchProM2: Double = 0.0,
    val gewichtPro1000Stk: Int = 0
)