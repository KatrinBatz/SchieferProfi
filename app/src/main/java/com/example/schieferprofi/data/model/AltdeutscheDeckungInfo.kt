package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AltdeutscheDeckungInfo(
    val decksteinRegeln: DecksteinRegeln = DecksteinRegeln(),
    val sortierung: Sortierung = Sortierung(),
    val ueberdeckungen: Ueberdeckungen = Ueberdeckungen(),
    val steinZuordnung: SteinZuordnung = SteinZuordnung()
)

@Serializable
data class DecksteinRegeln(
    val hiebarten: List<String> = emptyList(),
    val befestigungDach: String = "",
    val befestigungWand: String = "",
    val bemerkung: String = ""
)

@Serializable
data class Sortierung(
    val sparren: List<SortierEintrag> = emptyList(),
    val wand: List<SortierEintrag> = emptyList()
)

@Serializable
data class SortierEintrag(
    val hoeheMeter: String = "",
    val differenzMm: Int = 0,
    val sortierungen: Int = 0
)

@Serializable
data class UeberdeckungsTabelle(
    val werte: List<Ueberdeckungseintrag> = emptyList()
)

@Serializable
data class Ueberdeckungseintrag(
    val steinhoeheCm: Int = 0,
    val ueberdeckungNormal: Int = 0,
    val ueberdeckungScharf: Int = 0,
    val sortierung: String = ""
)

@Serializable
data class SteinZuordnung(
    val monumentum: List<OrtKehlZuordnung> = emptyList(),
    val intersin: List<OrtKehlZuordnung> = emptyList()
)

@Serializable
data class OrtKehlZuordnung(
    val sortierung: String = "",
    val anfangOrt: String = "",
    val endOrt: String = "",
    val kehlsteine: List<String> = emptyList()
)