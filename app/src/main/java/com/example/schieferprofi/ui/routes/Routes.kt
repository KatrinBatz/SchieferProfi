package com.example.schieferprofi.ui.routes

import com.example.schieferprofi.data.model.DecksteinRegeln
import com.example.schieferprofi.data.model.Sortierung
import com.example.schieferprofi.data.model.SteinZuordnung
import com.example.schieferprofi.data.model.Ueberdeckungen

data class AltdeutscheDetailRoute(
    val decksteinRegeln: DecksteinRegeln,
    val sortierung: Sortierung,
    val ueberdeckungen: Ueberdeckungen,
    val steinZuordnung: SteinZuordnung
)
