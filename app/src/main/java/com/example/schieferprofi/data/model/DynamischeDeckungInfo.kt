package com.example.schieferprofi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class DynamischeDeckungInfo(
    val beschreibung: String = "",
    val deckunterlage: String = "",
    val befestigung: DynamischeBefestigung = DynamischeBefestigung(),
    val ueberdeckungHinweis: String = "",
    val stosfugenHinweis: String = "",
    val ortdeckungHinweis: String = "",
    val standardformate: List<String> = emptyList(),
    val deckbildHinweis: String = ""
)

@Serializable
data class DynamischeBefestigung(
    val hinweis: String = "",
    val befestigungNachBreite: List<BefestigungNachBreite> = emptyList()
)

@Serializable
data class BefestigungNachBreite(
    val maximaleBreite: Int = 0,
    val befestigungsmittel: Int = 0
)