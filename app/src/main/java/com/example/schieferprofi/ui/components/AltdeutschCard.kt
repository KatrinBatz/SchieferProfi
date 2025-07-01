package com.example.schieferprofi.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.schieferprofi.data.model.AltdeutscheDeckungInfo

@Composable
fun AltdeutschCard(altdeutsch: AltdeutscheDeckungInfo) {
    GlassmorphismCard {
        Column(modifier = Modifier.padding(16.dp)) {

            // 🔹 DecksteinRegeln
            Text("🪨 Deckstein-Regeln", fontWeight = FontWeight.Bold)
            Text("• Hiebarten: ${altdeutsch.decksteinRegeln.hiebarten.joinToString(", ")}")
            Text("• Befestigung Dach: ${altdeutsch.decksteinRegeln.befestigungDach}")
            Text("• Befestigung Wand: ${altdeutsch.decksteinRegeln.befestigungWand}")
            Text("• Bemerkung: ${altdeutsch.decksteinRegeln.bemerkung}")

            Spacer(modifier = Modifier.height(12.dp))

            // 🔹 Sortierung Sparren
            Text("📏 Sortierung – Sparren", fontWeight = FontWeight.Bold)
            altdeutsch.sortierung.sparren.forEach { eintrag ->
                Text("• Höhe: ${eintrag.hoeheMeter}, Differenz: ${eintrag.differenzMm} mm, Sortierungen: ${eintrag.sortierungen}")
            }

            // 🔹 Sortierung Wand
            Text("📐 Sortierung – Wand", fontWeight = FontWeight.Bold)
            altdeutsch.sortierung.wand.forEach { eintrag ->
                Text("• Höhe: ${eintrag.hoeheMeter}, Differenz: ${eintrag.differenzMm} mm, Sortierungen: ${eintrag.sortierungen}")
            }

            Spacer(modifier = Modifier.height(12.dp))

            // 🔹 Überdeckungen (wenn du später UeberdeckungsTabelle einfügst)
            // Text("🔽 Überdeckungen", fontWeight = FontWeight.Bold)
            // altdeutsch.ueberdeckungen.werte.forEach {
            //     Text("• ${it.steinhoeheCm} cm: normal=${it.ueberdeckungNormal} mm, scharf=${it.ueberdeckungScharf} mm – ${it.sortierung}")
            // }

            Spacer(modifier = Modifier.height(12.dp))

            // 🔹 Stein-Zuordnung Monumentum
            Text("🏛️ Monumentum-Zuordnung", fontWeight = FontWeight.Bold)
            altdeutsch.steinZuordnung.monumentum.forEach {
                Text("• Sortierung: ${it.sortierung}")
                Text("  Anfang Ort: ${it.anfangOrt}, Ende Ort: ${it.endOrt}")
                Text("  Kehlsteine: ${it.kehlsteine.joinToString(", ")}")
            }

            // 🔹 Stein-Zuordnung Intersin
            Text("🏗️ Intersin-Zuordnung", fontWeight = FontWeight.Bold)
            altdeutsch.steinZuordnung.intersin.forEach {
                Text("• Sortierung: ${it.sortierung}")
                Text("  Anfang Ort: ${it.anfangOrt}, Ende Ort: ${it.endOrt}")
                Text("  Kehlsteine: ${it.kehlsteine.joinToString(", ")}")
            }
        }
    }
}