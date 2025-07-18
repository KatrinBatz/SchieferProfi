package com.example.schieferprofi.ui.components

import androidx.compose.foundation.border
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.schieferprofi.R
import com.example.schieferprofi.data.model.DeckungsRegelwerk
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle

@Composable
fun DeckungsRegelwerkCard(
    regelwerk: DeckungsRegelwerk
) {

    GlassmorphismCard {
        Column(modifier = Modifier.padding(8.dp)) {

            Text("🔹 Deckarten", style = schieferSecondaryStyle())
            regelwerk.deckarten.forEach { deckart ->
                Spacer(modifier = Modifier.height(16.dp))
                Text(deckart.name, style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(deckart.beschreibung, style = schieferSecondaryStyle())
                Text("Typisch für: ${deckart.typischFuerRegion}", style = schieferSecondaryStyle())
                Text("Materialbedarf: ${deckart.materialbedarfProM2}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(10.dp))
                AsyncImage(
                    model = deckart.bildUrl,
                    contentDescription = deckart.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(2.dp, colorResource(R.color.schiefergrau), RoundedCornerShape(12.dp))
                        .shadow(
                            elevation = 20.dp,
                            shape = RoundedCornerShape(12.dp),
                            clip = false
                        ),
                    contentScale = ContentScale.Crop
                )
            }

            HorizontalDivider(Modifier.padding(vertical = 16.dp))

            Text("📐 Regeldachneigungen", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
            Spacer(modifier = Modifier.height(10.dp))
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

            Text("🧰 Befestigung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
            Spacer(modifier = Modifier.height(10.dp))
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

            Text("📏 Überdeckungen (Dach)", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
            Spacer(modifier = Modifier.height(10.dp))
            regelwerk.ueberdeckungen.dach.forEach {
                Text("${it.deckart}: Höhe ${it.hoehe}, Seite: ${it.seite}, Latten: ${it.lattenabstand}, Stein: ${it.steingroesse}", style = schieferBodyStyle())
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text("📏 Überdeckungen (Wand)", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
            Spacer(modifier = Modifier.height(10.dp))
            regelwerk.ueberdeckungen.wand.forEach {
                Text("${it.deckart}: Höhe ${it.hoehe}, Latten: ${it.lattenabstand}, Stein: ${it.steingroesse}", style = schieferBodyStyle())
            }

            HorizontalDivider(Modifier.padding(vertical = 16.dp))

            Text("📦 Unterlagen", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
            Spacer(modifier = Modifier.height(10.dp))
            Text("Holz: ${regelwerk.unterlagen.holz}", style = schieferBodyStyle())
            Text("Holzwerkstoffe: ${regelwerk.unterlagen.holzwerkstoffe}", style = schieferBodyStyle())
            if (regelwerk.unterlagen.normen.isNotEmpty()) {
                Text("📚 Normen:", style = schieferSecondaryStyle())
                regelwerk.unterlagen.normen.forEach { norm ->
                    Text("• $norm", style = schieferSecondaryStyle())
                }
            }

            HorizontalDivider(Modifier.padding(vertical = 16.dp))

            Text("🛠️ Werkzeuge", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
            Spacer(modifier = Modifier.height(10.dp))
            regelwerk.werkzeuge.forEach {
                Text("• $it", style = schieferBodyStyle())
            }

            if (regelwerk.sicherheitshinweise.isNotBlank()) {
                HorizontalDivider(Modifier.padding(vertical = 16.dp))
                Text("⚠️ Sicherheitshinweise", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(regelwerk.sicherheitshinweise, style = schieferBodyStyle())
            }

            if (regelwerk.verarbeitungshinweise.isNotBlank()) {
                HorizontalDivider(Modifier.padding(vertical = 16.dp))
                Text("🧱 Verarbeitungshinweise", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(regelwerk.verarbeitungshinweise, style = schieferBodyStyle())
            }

            if (regelwerk.normVerweise.isNotEmpty()) {
                HorizontalDivider(Modifier.padding(vertical = 16.dp))
                Text("📖 Normverweise", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                regelwerk.normVerweise.forEach {
                    Text("• $it", style = schieferSecondaryStyle())
                }
            }

            if (regelwerk.pflege.isNotBlank()) {
                HorizontalDivider(Modifier.padding(vertical = 16.dp))
                Text("🧼 Pflege", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(regelwerk.pflege, style = schieferBodyStyle())
            }

            if (regelwerk.allgemeines.isNotBlank()) {
                HorizontalDivider(Modifier.padding(vertical = 16.dp))
                Text("ℹ️ Allgemeines", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(regelwerk.allgemeines, style = schieferBodyStyle())
            }
        }
    }
}
