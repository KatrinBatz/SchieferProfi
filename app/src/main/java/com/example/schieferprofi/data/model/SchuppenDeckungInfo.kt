package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SchuppenDeckungInfo(
    val beschreibung: String = "",
    val decksteinmodell: List<String> = emptyList(),
    val deckunterlage: String = "",
    val befestigungDach: String = "",
    val befestigungWand: String = "",
    val ueberdeckungen: String = "",
    val deckartenHinweis: String = "",
    val masseDach: List<SchuppenDachFormat> = emptyList(),
    val masseWand: List<SchuppenWandFormat> = emptyList(),
    val zuordnung: List<SchuppenZuordnung> = emptyList(),
    val rechenbeispiel: String = ""
)

@Serializable
data class SchuppenDachFormat(
    val hoehe: String = "",
    val breite: String = "",
    val bedarfProM2: Double = 0.0,
    val ueberdeckung: String = "",
    val geeignetFuerDachneigung: String = "",
    val kgPro1000: Int = 0,
    val stueckProKiste: Int = 0
)

@Serializable
data class SchuppenWandFormat(
    val hoehe: String = "",
    val breite: String = "",
    val bedarfProM2: Double = 0.0,
    val seitenueberdeckung: Int = 0,
    val hoehenueberdeckung: Int = 0,
    val kgPro1000: Int = 0,
    val stueckProKiste: Int = 0
)

@Serializable
data class SchuppenZuordnung(
    val schuppengroesse: String = "",
    val anfangOrt: String = "",
    val endOrt: String = "",
    val kehlsteine: List<String> = emptyList(),
    val fersenversatz: String = "",
    val rohsortierung: String = ""
)