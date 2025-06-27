package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UniversalDeckungInfo(
    val beschreibung: String = "",
    val decksteinmodell: List<String> = emptyList(),
    val deckunterlage: String = "",
    val befestigungDach: String = "",
    val befestigungWand: String = "",
    val fussdeckung: String = "",
    val ortGratFirst: String = "",
    val formateWand: List<UniversalFormatWand> = emptyList(),
    val formateHochformat: List<UniversalFormatHoch> = emptyList(),
    val gleichortGebindeInfo: String = "",
    val ortdeckung: String = ""
)

@Serializable
data class UniversalFormatWand(
    val bedarfProM2: Double = 0.0,
    val lattenabstandCm: Int = 0,
    val lattenverbrauchM: Double = 0.0,
    val gewichtPro1000: Int = 0,
    val stkProKiste: Int = 0
)

@Serializable
data class UniversalFormatHoch(
    val groesse: String = "",
    val bedarfProM2: Double = 0.0,
    val waagerecht: Double = 0.0,
    val senkrecht: Double = 0.0,
    val gewichtPro1000: Int = 0,
    val stkProKiste: Int = 0
)