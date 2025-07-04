package com.example.schieferprofi.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DividerDefaults
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
import com.example.schieferprofi.data.model.GezogeneDeckungInfo
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle

@Composable
fun GezogeneCard(gezogene: GezogeneDeckungInfo, deckung: Deckung) {
    GlassmorphismCard {
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
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

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 4.dp),
                    thickness = DividerDefaults.Thickness,
                    color = DividerDefaults.color
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text("📘 Beschreibung", style = schieferTitleStyle())
                Text(gezogene.beschreibung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("🔧 Deckunterlage", style = schieferTitleStyle())
                Text(gezogene.deckunterlage, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("🪚 Befestigung", style = schieferTitleStyle())
                Text("• Haken: ${gezogene.befestigung.haken}", style = schieferBodyStyle())
                Text("• Schrauben: ${gezogene.befestigung.schrauben}", style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("📏 Überdeckungen", style = schieferTitleStyle())
            }
            items(gezogene.ueberdeckungen) { eintrag ->
                Text("• Befestigungsart: ${eintrag.befestigungsart}", style = schieferBodyStyle())
                Text("  Höhenüberdeckung: ${eintrag.hoehenueberdeckung} mm", style = schieferSecondaryStyle())
                Text("  Seitenüberdeckung: ${eintrag.seitenueberdeckung} mm", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }
            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📦 Materialbedarf", style = schieferTitleStyle())
            }
            items(gezogene.materialbedarf) { material ->
                Text("• Format: ${material.format} (${material.ueberdeckung})", style = schieferBodyStyle())
                Text("  Schieferbedarf: ${material.schieferbedarf} Stück/m²", style = schieferSecondaryStyle())
                Text("  Hakenverbrauch: ${material.hakenverbrauch} Stück/m²", style = schieferSecondaryStyle())
                Text("  Lattenabstand: ${material.lattenabstand} cm", style = schieferSecondaryStyle())
                Text("  Lattenverbrauch: ${material.lattenverbrauch} lfm/m²", style = schieferSecondaryStyle())
                Text("  Gewicht pro 1000 Stück: ${material.gewichtPro1000Stk} kg", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📐 Einteilung", style = schieferTitleStyle())
                Text("• Beschreibung: ${gezogene.einteilung.beschreibung}", style = schieferBodyStyle())
                Text("• Rechenbeispiel: ${gezogene.einteilung.rechenbeispiel}", style = schieferSecondaryStyle())
                Text("• Bemerkung: ${gezogene.einteilung.bemerkung}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("🧮 Materialbedarf-Berechnung", style = schieferTitleStyle())
                Text("• Formel: ${gezogene.materialbedarfBerechnung.formel}", style = schieferBodyStyle())
                Text("• Rechenbeispiel: ${gezogene.materialbedarfBerechnung.rechenbeispiel}", style = schieferSecondaryStyle())
            }
        }
    }
}