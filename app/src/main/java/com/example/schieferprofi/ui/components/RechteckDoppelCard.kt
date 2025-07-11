package com.example.schieferprofi.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.schieferprofi.R
import com.example.schieferprofi.data.model.Deckung
import com.example.schieferprofi.data.model.FavoritenDeckart
import com.example.schieferprofi.data.model.RechteckDoppeldeckungInfo
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun RechteckDoppelCard(
    rechteckDoppel: RechteckDoppeldeckungInfo,
    deckung: Deckung,
    viewModel: FavoritenViewModel = koinViewModel()
    ) {

    LaunchedEffect(Unit) {
        viewModel.ladeFavoriten()
    }

    GlassmorphismCard {
        LazyColumn(modifier = Modifier.padding(16.dp).fillMaxWidth()) {

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
                FavoritenIconButton(
                    deckart = FavoritenDeckart(
                        idDeckart = deckung.id,
                        deckartName = deckung.name,
                        deckartBeschreibung = deckung.beschreibung,
                        deckartBild = deckung.bildUrl
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(deckung.beschreibung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Verwendung: ${deckung.verwendung.joinToString()}", style = schieferSecondaryStyle())
                Text("Schwierigkeitsgrad: ${deckung.schwierigkeitsgrad}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text("📘 Beschreibung", style = schieferTitleStyle())
                Text(rechteckDoppel.beschreibung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))
                Text("🧱 Deckunterlage", style = schieferTitleStyle())
                Text(rechteckDoppel.deckunterlage, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))
                Text("🗺️ Deckschema", style = schieferTitleStyle())
                Text(rechteckDoppel.deckschema, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))
                Text("🔩 Befestigung", style = schieferTitleStyle())
                Text("• Dach: ${rechteckDoppel.befestigung.dach}", style = schieferBodyStyle())
                Text("• Ort/Grat: ${rechteckDoppel.befestigung.ortGrat}", style = schieferBodyStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("🏗️ Formate Dach", style = schieferTitleStyle())
            }

            items(rechteckDoppel.formateDach) {
                Text("• Dach: ${it.dach}", style = schieferBodyStyle())
                Text("  Ort/Grat: ${it.ortGrat}", style = schieferSecondaryStyle())
                Text("  Anmerkung: ${it.anmerkung}", style = schieferSecondaryStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("🏠 Formate Wand (Haken)", style = schieferTitleStyle())
            }

            items(rechteckDoppel.formateWandHaken) {
                Text("• Format: ${it.format}, Überdeckung: ${it.hoehenueberdeckung} mm", style = schieferBodyStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("🔨 Formate Wand (Nagel)", style = schieferTitleStyle())
            }

            items(rechteckDoppel.formateWandNagel) {
                Text("• Format: ${it.format}, Überdeckung: ${it.hoehenueberdeckung} mm", style = schieferBodyStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📦 Materialbedarf Dach", style = schieferTitleStyle())
            }

            items(rechteckDoppel.materialbedarfDach) {
                Text("• Format: ${it.format}", style = schieferBodyStyle())
                Text("  Schieferbedarf: ${it.schieferbedarf} Stk/m²", style = schieferSecondaryStyle())
                Text("  Hakenverbrauch: ${it.hakenverbrauch} Stk/m²", style = schieferSecondaryStyle())
                Text("  Lattenabstand: ${it.lattenabstand} cm", style = schieferSecondaryStyle())
                Text("  Lattenverbrauch: ${it.lattenverbrauch} lfm/m²", style = schieferSecondaryStyle())
                Text("  Gewicht pro 1000 Stk: ${it.gewichtPro1000Stk} kg", style = schieferSecondaryStyle())
                Text("  Stück pro Kiste: ${it.stueckProKiste}", style = schieferSecondaryStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("🏰 Ort, Grat & First", style = schieferTitleStyle())
                Text("• Traufe: ${rechteckDoppel.ortGratFirst.traufe}", style = schieferBodyStyle())
                Text("• First: ${rechteckDoppel.ortGratFirst.first}", style = schieferBodyStyle())
                Text("• Ortgang: ${rechteckDoppel.ortGratFirst.ortgang.joinToString()}", style = schieferSecondaryStyle())
                Text("• Grat: ${rechteckDoppel.ortGratFirst.grat.joinToString()}", style = schieferSecondaryStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("🌀 Kehlen", style = schieferTitleStyle())
                Text("• Hinweis: ${rechteckDoppel.kehlen.hinweis}", style = schieferBodyStyle())
                Text("• Hauptkehle: ${rechteckDoppel.kehlen.hauptkehle}", style = schieferSecondaryStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("🎯 Sonderformen", style = schieferTitleStyle())
                Text(rechteckDoppel.sonderformen.hinweis, style = schieferBodyStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📐 Einteilungsbeispiel", style = schieferTitleStyle())
                val e = rechteckDoppel.einteilungsbeispiel
                Text("• Wandbreite: ${e.wandbreite} cm", style = schieferBodyStyle())
                Text("• Steinformat: ${e.steinformat}", style = schieferBodyStyle())
                Text("• Fugenabstand: ${e.fugenabstand} cm", style = schieferBodyStyle())
                Text("• Nutzbreite: ${e.nutzbreite} cm", style = schieferBodyStyle())
                Text("• Anzahl Steine: ${e.anzahlSteine}", style = schieferBodyStyle())
                Text("• Schnurschlag oben: ${e.schnurschlagOben} cm", style = schieferSecondaryStyle())
                Text("• Schnurschlag unten: ${e.schnurschlagUnten} cm", style = schieferSecondaryStyle())
                Text("• Bemerkung: ${e.bemerkung}", style = schieferSecondaryStyle())
            }
        }
    }
}