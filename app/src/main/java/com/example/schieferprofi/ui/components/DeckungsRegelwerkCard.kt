package com.example.schieferprofi.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.schieferprofi.data.model.DeckungsRegelwerk
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle

@Composable
fun DeckungsRegelwerkCard(
    regelwerk: DeckungsRegelwerk
) {

    GlassmorphismCard {
        Column(modifier = Modifier.padding(16.dp)) {

            Text("📘 Deckungsregelwerk", style = schieferTitleStyle())
            Spacer(modifier = Modifier.height(8.dp))

            // 🔹 Deckarten
            Text("🔹 Deckarten", style = schieferSecondaryStyle())
            regelwerk.deckarten.forEach { deckart ->
                Spacer(modifier = Modifier.height(8.dp))
                Text(deckart.name, style = schieferBodyStyle())
                Text(deckart.beschreibung, style = schieferSecondaryStyle())
                Text("Typisch für: ${deckart.typischFuerRegion}", style = schieferSecondaryStyle())
                Text("Materialbedarf: ${deckart.materialbedarfProM2}", style = schieferSecondaryStyle())

                AsyncImage(
                    model = deckart.bildUrl,
                    contentDescription = deckart.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(6.dp))
//                        .clickable { zoomImageUrl = deckart.bildUrl }
                        .shadow(6.dp),
                    contentScale = ContentScale.Crop
                )
            }

            HorizontalDivider(Modifier.padding(vertical = 16.dp))

            // 📐 Regeldachneigungen
            Text("📐 Regeldachneigungen", style = schieferTitleStyle())
            Spacer(modifier = Modifier.height(8.dp))
            regelwerk.regeldachneigungen.forEach {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("${it.deckart} (${it.dachneigungGrad}°)", modifier = Modifier.weight(1f), style = schieferBodyStyle())
                    Text("→ ${it.einsatzbereich}", modifier = Modifier.weight(1f), style = schieferSecondaryStyle())
                }
                if (it.zusatzHinweis.isNotBlank()) {
                    Text("Hinweis: ${it.zusatzHinweis}", style = schieferSecondaryStyle())
                }
            }

            HorizontalDivider(Modifier.padding(vertical = 16.dp))

            // 🧰 Befestigungen
            Text("🧰 Befestigung", style = schieferTitleStyle())
            Text(regelwerk.befestigung.regeln, style = schieferBodyStyle())
            regelwerk.befestigung.tabelle.forEach {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(it.name, style = schieferBodyStyle(), modifier = Modifier.weight(1f))
                    Text("⌀ ${it.durchmesser} · ${it.laenge} lang", style = schieferSecondaryStyle(), modifier = Modifier.weight(1f))
                    Text("Auszugswert: ${it.auszugswert}", style = schieferSecondaryStyle(), modifier = Modifier.weight(1f))
                }
                Text("→ ${it.anwendungsbereich}", style = schieferSecondaryStyle())
            }

            HorizontalDivider(Modifier.padding(vertical = 16.dp))

            // 📏 Überdeckungen
            Text("📏 Überdeckungen (Dach)", style = schieferTitleStyle())
            regelwerk.ueberdeckungen.dach.forEach {
                Text("${it.deckart}: Höhe ${it.hoehe}, Seite: ${it.seite}, Latten: ${it.lattenabstand}, Stein: ${it.steingroesse}", style = schieferBodyStyle())
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text("📏 Überdeckungen (Wand)", style = schieferTitleStyle())
            regelwerk.ueberdeckungen.wand.forEach {
                Text("${it.deckart}: Höhe ${it.hoehe}, Latten: ${it.lattenabstand}, Stein: ${it.steingroesse}", style = schieferBodyStyle())
            }

            HorizontalDivider(Modifier.padding(vertical = 16.dp))

            // 📦 Unterlagen
            Text("📦 Unterlagen", style = schieferTitleStyle())
            Text("Holz: ${regelwerk.unterlagen.holz}", style = schieferBodyStyle())
            Text("Holzwerkstoffe: ${regelwerk.unterlagen.holzwerkstoffe}", style = schieferBodyStyle())
            if (regelwerk.unterlagen.normen.isNotEmpty()) {
                Text("📚 Normen:", style = schieferSecondaryStyle())
                regelwerk.unterlagen.normen.forEach { norm ->
                    Text("• $norm", style = schieferSecondaryStyle())
                }
            }

            HorizontalDivider(Modifier.padding(vertical = 16.dp))

            // 🛠️ Werkzeuge
            Text("🛠️ Werkzeuge", style = schieferTitleStyle())
            regelwerk.werkzeuge.forEach {
                Text("• $it", style = schieferBodyStyle())
            }

            // ⚠️ Sicherheit
            if (regelwerk.sicherheitshinweise.isNotBlank()) {
                HorizontalDivider(Modifier.padding(vertical = 16.dp))
                Text("⚠️ Sicherheitshinweise", style = schieferTitleStyle())
                Text(regelwerk.sicherheitshinweise, style = schieferBodyStyle())
            }

            // 🧱 Verarbeitung
            if (regelwerk.verarbeitungshinweise.isNotBlank()) {
                HorizontalDivider(Modifier.padding(vertical = 16.dp))
                Text("🧱 Verarbeitungshinweise", style = schieferTitleStyle())
                Text(regelwerk.verarbeitungshinweise, style = schieferBodyStyle())
            }

            // 📖 Normverweise
            if (regelwerk.normVerweise.isNotEmpty()) {
                HorizontalDivider(Modifier.padding(vertical = 16.dp))
                Text("📖 Normverweise", style = schieferTitleStyle())
                regelwerk.normVerweise.forEach {
                    Text("• $it", style = schieferSecondaryStyle())
                }
            }

            // 🧼 Pflege
            if (regelwerk.pflege.isNotBlank()) {
                HorizontalDivider(Modifier.padding(vertical = 16.dp))
                Text("🧼 Pflege", style = schieferTitleStyle())
                Text(regelwerk.pflege, style = schieferBodyStyle())
            }

            // ℹ️ Allgemeines
            if (regelwerk.allgemeines.isNotBlank()) {
                HorizontalDivider(Modifier.padding(vertical = 16.dp))
                Text("ℹ️ Allgemeines", style = schieferTitleStyle())
                Text(regelwerk.allgemeines, style = schieferBodyStyle())
            }
        }
    }
}
