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
    val parameterErklaerung: SpitzwinkelParameterErklaerung = SpitzwinkelParameterErklaerung(),
    val ortGratFirst: SpitzwinkelOrtGratFirst = SpitzwinkelOrtGratFirst(),
    val masseUndStueckzahlen: List<SpitzwinkelMasse> = emptyList(),
    val materialbedarfFormel: String = "",
    val parameterErklaerungMaterialbedarf: SpitzwinkelParameterMaterial = SpitzwinkelParameterMaterial()
)

@Serializable
data class SpitzwinkelUeberdeckung(
    val beschreibung: String = ""
)

@Serializable
data class SpitzwinkelParameterErklaerung(
    val h: String = "",
    val a: String = "",
    val m: String = ""
)

@Serializable
data class SpitzwinkelOrtGratFirst(
    val orte: String = "",
    val grate: String = "",
    val first: String = "",
    val traufe: String = ""
)

@Serializable
data class SpitzwinkelMasse(
    val nummers: Int = 0,
    val groesseCm: String = "",
    val mindDachneigungGrad: String = "",
    val bedarfProM2: Double = 0.0,
    val abschnittMm: Int = 0,
    val gewichtKg: Int = 0,
    val kistenInhalt: Int = 0
)

@Serializable
data class SpitzwinkelParameterMaterial(
    val l: String = "",
    val a: String = "",
    val hs: String = "",
    val b: String = ""
)