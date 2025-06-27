package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BogenschnittDeckungInfo(
    val beschreibung: String = "",
    val decksteinmodell: List<String> = emptyList(),
    val deckunterlage: String = "",
    val befestigungDach: String = "",
    val befestigungWand: String = "",
    val fussdeckung: String = "",
    val ortGratFirst: String = "",
    val formateWand: List<BogenschnittFormat> = emptyList(),
    val ortZuordnung: List<BogenschnittOrtZuordnung> = emptyList(),
    val kehlMaterial: List<KehlMaterial> = emptyList()
)

@Serializable
data class BogenschnittFormat(
    val groesse: String = "",
    val hoehenUeberdeckung: Int = 0,
    val seitenUeberdeckung: Int = 0,
    val bedarfProM2: Double = 0.0,
    val lattenabstandCm: Int = 0,
    val lattenverbrauchM: Double = 0.0,
    val gewichtPro1000: Int = 0,
    val stkProKiste: Int = 0
)

@Serializable
data class BogenschnittOrtZuordnung(
    val format: String = "",
    val hoehenUeberdeckung: Int = 0,
    val anfangort: String = "",
    val endort: String = "",
    val stkProM: Int = 0
)

@Serializable
data class KehlMaterial(
    val sortierung: String = "",
    val masse: String = ""
)