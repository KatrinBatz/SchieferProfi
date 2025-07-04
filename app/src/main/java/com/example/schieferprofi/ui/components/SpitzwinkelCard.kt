package com.example.schieferprofi.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.schieferprofi.R
import com.example.schieferprofi.data.model.Deckung
import com.example.schieferprofi.data.model.SpitzwinkelDeckungInfo
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle

@Composable
fun SpitzwinkelCard(spitzwinkel: SpitzwinkelDeckungInfo, deckung: Deckung) {
    GlassmorphismCard {
        LazyColumn(modifier = Modifier.padding(16.dp)) {

            item {
                AsyncImage(
                    model = deckung.bildUrl,
                    contentDescription = "Bild von ${deckung.name}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(2.dp, colorResource(R.color.schiefergrau), RoundedCornerShape(12.dp))
                        .shadow(20.dp, RoundedCornerShape(12.dp), clip = false),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(deckung.name, style = schieferTitleStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text(deckung.beschreibung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Verwendung: ${deckung.verwendung.joinToString()}", style = schieferSecondaryStyle())
                Text("Schwierigkeitsgrad: ${deckung.schwierigkeitsgrad}", style = schieferSecondaryStyle())

                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
                Spacer(modifier = Modifier.height(8.dp))

                Text("📘 Beschreibung", style = schieferTitleStyle())
                Text(spitzwinkel.beschreibung, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🪨 Decksteinmodell", style = schieferTitleStyle())
                spitzwinkel.decksteinmodell.forEach {
                    Text("• $it", style = schieferBodyStyle())
                }

                Spacer(modifier = Modifier.height(12.dp))
                Text("🧱 Deckunterlage", style = schieferTitleStyle())
                Text(spitzwinkel.deckunterlage, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🔩 Befestigung", style = schieferTitleStyle())
                Text(spitzwinkel.befestigung, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("📏 Überdeckung", style = schieferTitleStyle())
                Text(spitzwinkel.ueberdeckung.beschreibung, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("📐 Schnürrabstand-Formel", style = schieferTitleStyle())
                Text(spitzwinkel.schnuerabstandFormel, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(8.dp))
                Text("🔣 Formel-Parameter", style = schieferTitleStyle())
                Text("• H: ${spitzwinkel.parameterErklärung.H}", style = schieferBodyStyle())
                Text("• A: ${spitzwinkel.parameterErklärung.A}", style = schieferBodyStyle())
                Text("• M: ${spitzwinkel.parameterErklärung.M}", style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🏰 Ort, Grat & First", style = schieferTitleStyle())
                Text("• Traufe: ${spitzwinkel.ortGratFirst.traufe}", style = schieferBodyStyle())
                Text("• Ort: ${spitzwinkel.ortGratFirst.orte}", style = schieferSecondaryStyle())
                Text("• Grat: ${spitzwinkel.ortGratFirst.grate}", style = schieferSecondaryStyle())
                Text("• First: ${spitzwinkel.ortGratFirst.first}", style = schieferSecondaryStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📦 Maße & Stückzahlen", style = schieferTitleStyle())
            }

            items(spitzwinkel.masseUndStueckzahlen) {
                Text("• Größe: ${it.groesseCm}", style = schieferBodyStyle())
                Text("  Nummer: ${it.nummer}", style = schieferSecondaryStyle())
                Text("  Mindest-Dachneigung: ${it.mindDachneigungGrad}", style = schieferSecondaryStyle())
                Text("  Bedarf: ${it.bedarfProM2} Stk/m²", style = schieferSecondaryStyle())
                Text("  Abschnitt: ${it.abschnittMm} mm", style = schieferSecondaryStyle())
                Text("  Gewicht: ${it.gewichtKg} kg", style = schieferSecondaryStyle())
                Text("  Kisteninhalt: ${it.kistenInhalt} Stk", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("🧮 Materialbedarf-Formel", style = schieferTitleStyle())
                Text(spitzwinkel.materialbedarfFormel, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(8.dp))
                Text("🔣 Parameter Materialbedarf", style = schieferTitleStyle())
                Text("• L: ${spitzwinkel.parameterErklaerungMaterialbedarf.L}", style = schieferBodyStyle())
                Text("• A: ${spitzwinkel.parameterErklaerungMaterialbedarf.A}", style = schieferBodyStyle())
                Text("• Hs: ${spitzwinkel.parameterErklaerungMaterialbedarf.Hs}", style = schieferBodyStyle())
                Text("• B: ${spitzwinkel.parameterErklaerungMaterialbedarf.B}", style = schieferBodyStyle())
            }
        }
    }
}