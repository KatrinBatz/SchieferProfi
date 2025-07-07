package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Gebindesteigung1Info (
    val bildUrl: String = "",
    val tabelle: List<Hoechtgebindewert>
)

@Serializable
data class Hoechtgebindewert (
    val hiebdeckart: String = "",
    val alpha: Double = 0.0,
    val steigung: Double = 0.0
)