package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class DeckungsRegelwerk(
    val deckarten: List<DeckartInfo> = emptyList(),
    val regeldachneigungen: List<Regeldachneigung> = emptyList(),
    val befestigung: BefestigungsRegeln = BefestigungsRegeln(),
    val unterlagen: Unterlagen = Unterlagen(),
    val ueberdeckungen: Ueberdeckungen = Ueberdeckungen(),
    val pflege: String = "",
    val allgemeines: String = ""
)

@Serializable
data class DeckartInfo(
    val name: String = "",
    val beschreibung: String = ""
)

@Serializable
data class Regeldachneigung(
    val deckart: String = "",
    val dachneigungGrad: Int = 0,
    val prozent: String = ""
)

@Serializable
data class BefestigungsRegeln(
    val regeln: String = "",
    val tabelle: List<Befestigungsart> = emptyList()
)

@Serializable
data class Befestigungsart(
    val name: String = "",
    val durchmesser: String = "",
    val laenge: String = "",
    val auszugswert: Int = 0
)

@Serializable
data class Unterlagen(
    val holz: String = "",
    val holzwerkstoffe: String = ""
)

@Serializable
data class Ueberdeckungen(
    val dach: List<UeberdeckungDach> = emptyList(),
    val wand: List<UeberdeckungWand> = emptyList()
)

@Serializable
data class UeberdeckungDach(
    val deckart: String = "",
    val hoehe: String = "",
    val seite: String = ""
)

@Serializable
data class UeberdeckungWand(
    val deckart: String = "",
    val hoehe: String = ""
)