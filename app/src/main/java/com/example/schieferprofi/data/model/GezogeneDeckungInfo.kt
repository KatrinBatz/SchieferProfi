package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class GezogeneDeckungInfo(
    val beschreibung: String = "",
    val deckunterlage: String = "",
    val befestigung: GezogeneBefestigung = GezogeneBefestigung(),
    val ueberdeckungen: List<GezogeneUeberdeckung> = emptyList(),
    val materialbedarf: List<GezogeneMaterialbedarf> = emptyList(),
    val einteilung: Einteilung = Einteilung(),
    val materialbedarfBerechnung: MaterialbedarfBerechnung = MaterialbedarfBerechnung()
)

@Serializable
data class GezogeneBefestigung(
    val haken: String = "",
    val schrauben: String = ""
)

@Serializable
data class GezogeneUeberdeckung(
    val befestigungsart: String = "",
    val hoehenueberdeckung: Int = 0,
    val seitenueberdeckung: Int = 0
)

@Serializable
data class GezogeneMaterialbedarf(
    val format: String = "",
    val ueberdeckung: String = "",
    val schieferbedarf: Double = 0.0,
    val hakenverbrauch: Double = 0.0,
    val lattenabstand: Double = 0.0,
    val lattenverbrauch: Double = 0.0,
    val gewichtPro1000Stk: Int = 0
)

@Serializable
data class Einteilung(
    val beschreibung: String = "",
    val rechenbeispiel: String = "",
    val bemerkung: String = ""
)

@Serializable
data class MaterialbedarfBerechnung(
    val formel: String = "",
    val rechenbeispiel: String = ""
)