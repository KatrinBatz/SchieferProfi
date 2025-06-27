package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SpitzwinkelDeckungInfo(
    val beschreibung: String = "",
    val decksteinmodell: List<String> = emptyList(),
    val deckunterlage: String = "",
    val befestigung: String = "",
    val ueberdeckung: SpitzwinkelUeberdeckung = SpitzwinkelUeberdeckung(),
    val schnuerabstandFormel: String = "",
    val parameterErklärung: SpitzwinkelParameterErklaerung = SpitzwinkelParameterErklaerung(),
    val ortGratFirst: SpitzwinkelOrtGratFirst = SpitzwinkelOrtGratFirst(),
    val masseUndStueckzahlen: List<SpitzwinkelMaße> = emptyList(),
    val materialbedarfFormel: String = "",
    val parameterErklaerungMaterialbedarf: SpitzwinkelParameterMaterial = SpitzwinkelParameterMaterial()
)

@Serializable
data class SpitzwinkelUeberdeckung(
    val beschreibung: String = ""
)

@Serializable
data class SpitzwinkelParameterErklaerung(
    val H: String = "",
    val A: String = "",
    val M: String = ""
)

@Serializable
data class SpitzwinkelOrtGratFirst(
    val orte: String = "",
    val grate: String = "",
    val first: String = "",
    val traufe: String = ""
)

@Serializable
data class SpitzwinkelMaße(
    val nummer: Int = 0,
    val groesseCm: String = "",
    val mindDachneigungGrad: String = "",
    val bedarfProM2: Double = 0.0,
    val abschnittMm: Int = 0,
    val gewichtKg: Int = 0,
    val kistenInhalt: Int = 0
)

@Serializable
data class SpitzwinkelParameterMaterial(
    val L: String = "",
    val A: String = "",
    val Hs: String = "",
    val B: String = ""
)