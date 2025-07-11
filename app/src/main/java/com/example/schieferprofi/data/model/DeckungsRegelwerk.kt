package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class DeckungsRegelwerk(
    val deckarten: List<DeckartInfo> = emptyList(),
    val regeldachneigungen: List<Regeldachneigung> = emptyList(),
    val befestigung: BefestigungsRegeln = BefestigungsRegeln(),
    val unterlagen: Unterlagen = Unterlagen(),
    val ueberdeckungen: Ueberdeckungen = Ueberdeckungen(),
    val werkzeuge: List<String> = emptyList(),
    val sicherheitshinweise: String = "",
    val verarbeitungshinweise: String = "",
    val normVerweise: List<String> = emptyList(),
    val pflege: String = "",
    val allgemeines: String = ""
)

@Serializable
data class DeckartInfo(
    val name: String = "",
    val beschreibung: String = "",
    val bildUrl: String = "",
    val typischFuerRegion: String = "",
    val materialbedarfProM2: String = ""
)

@Serializable
data class Regeldachneigung(
    val deckart: String = "",
    val dachneigungGrad: Int = 0,
    val prozent: String = "",
    val einsatzbereich: String = "",
    val zusatzHinweis: String = ""
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
    val auszugswert: Int = 0,
    val anwendungsbereich: String = ""
)

@Serializable
data class Unterlagen(
    val holz: String = "",
    val holzwerkstoffe: String = "",
    val normen: List<String> = emptyList()
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
    val seite: String = "",
    val lattenabstand: String = "",
    val steingroesse: String = ""
)

@Serializable
data class UeberdeckungWand(
    val deckart: String = "",
    val hoehe: String = "",
    val lattenabstand: String = "",
    val steingroesse: String = ""
)