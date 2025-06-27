package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WaagerechteDeckungInfo(
    val beschreibung: String = "",
    val deckunterlage: String = "",
    val deckbild: String = "",
    val befestigung: List<WaagerechteBefestigung> = emptyList(),
    val ueberdeckung: Ueberdeckung = Ueberdeckung(),
    val materialbedarf: List<WaagerechteMaterialbedarf> = emptyList(),
    val hakenbedarf: List<HakenbedarfEintrag> = emptyList(),
    val bedarfsformel: Bedarfsformel = Bedarfsformel()
)

@Serializable
data class WaagerechteBefestigung(
    val format: String = "",
    val schrauben: String = "",
    val haken: String = ""
)

@Serializable
data class Ueberdeckung(
    val hoehenueberdeckung: Int = 0,
    val seitenueberdeckung: Int = 0
)

@Serializable
data class WaagerechteMaterialbedarf(
    val format: String = "",
    val sichtbareGroesse: String = "",
    val schieferbedarf: Double = 0.0,
    val gewichtPro1000Stk: Int = 0
)

@Serializable
data class HakenbedarfEintrag(
    val format: String = "",
    val hakenverbrauch: Double = 0.0,
    val lattenabstand: Int = 0,
    val lattenverbrauch: Double = 0.0
)

@Serializable
data class Bedarfsformel(
    val formel: String = "",
    val rechenbeispiel: String = ""
)