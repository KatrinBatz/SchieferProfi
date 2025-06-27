package com.example.schieferprofi.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RechteckDoppeldeckungInfo(
    val beschreibung: String = "",
    val deckschema: String = "",
    val deckunterlage: String = "",
    val befestigung: RechteckBefestigung = RechteckBefestigung(),
    val formateDach: List<BefestigungRechteck> = emptyList(),
    val formateWandHaken: List<RechteckFormatWand> = emptyList(),
    val formateWandNagel: List<RechteckFormatWand> = emptyList(),
    val materialbedarfDach: List<RechteckMaterialbedarf> = emptyList(),
    val ortGratFirst: OrtGratFirst = OrtGratFirst(),
    val kehlen: Kehlen = Kehlen(),
    val sonderformen: Sonderformen = Sonderformen(),
    val einteilungsbeispiel: RechteckEinteilung = RechteckEinteilung()
)

@Serializable
data class BefestigungRechteck(
    val dach: String = "",
    val ortGrat: String = "",
    val anmerkung: String = ""
)

@Serializable
data class DeckungsFormatRechteck(
    val format: String = "",
    val dachneigung: String = "",
    val hoehenueberdeckung: HoehenueberdeckungMap = HoehenueberdeckungMap()
)

@Serializable
data class HoehenueberdeckungMap(
    @SerialName("≥ 40°") val ab40Grad: Int = 0,
    @SerialName("≥ 50°") val ab50Grad: Int = 0
)

@Serializable
data class RechteckFormatWand(
    val format: String = "",
    val hoehenueberdeckung: Int = 0
)

@Serializable
data class RechteckMaterialbedarf(
    val format: String = "",
    val schieferbedarf: Double = 0.0,
    val hakenverbrauch: Double = 0.0,
    val lattenabstand: Double = 0.0,
    val lattenverbrauch: Double = 0.0,
    val gewichtPro1000Stk: Int = 0,
    val stueckProKiste: Int = 0
)

@Serializable
data class OrtGratFirst(
    val traufe: String = "",
    val ortgang: List<String> = emptyList(),
    val grat: List<String> = emptyList(),
    val first: String = ""
)

@Serializable
data class Kehlen(
    val hinweis: String = "",
    val hauptkehle: String = ""
)

@Serializable
data class Sonderformen(
    val hinweis: String = ""
)

@Serializable
data class RechteckEinteilung(
    val wandbreite: Double = 0.0,
    val steinformat: String = "",
    val fugenabstand: Double = 0.0,
    val nutzbreite: Double = 0.0,
    val anzahlSteine: Int = 0,
    val schnurschlagOben: Double = 0.0,
    val schnurschlagUnten: Double = 0.0,
    val bemerkung: String = ""
)