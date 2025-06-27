package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class GebindesteigungInfo(
    val erklaerungRechnerisch: String = "",
    val erklaerungKonstruktiv: String = "",
    val tabelle: List<Gebindesteigungswert> = emptyList()
)

@Serializable
data class Gebindesteigungswert(
    val dachneigung: Int = 0,
    val mindestGebindesteigung: Double = 0.0
)