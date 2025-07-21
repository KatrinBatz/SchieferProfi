package com.example.schieferprofi.ui.components

import FavoritenIconButton
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.schieferprofi.R
import com.example.schieferprofi.data.model.Deckung
import com.example.schieferprofi.data.entity.FavoritenDeckart
import com.example.schieferprofi.data.model.SpitzwinkelDeckungInfo
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SpitzwinkelCard(
    spitzwinkel: SpitzwinkelDeckungInfo,
    deckung: Deckung,
    snackbarHostState: SnackbarHostState,
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
                        .shadow(
                            elevation = 20.dp,
                            shape = RoundedCornerShape(12.dp),
                            clip = false
                        ),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        deckung.name,
                        style = schieferTitleStyle(),
                        textDecoration = TextDecoration.Underline
                    )
                    FavoritenIconButton(
                        deckart = FavoritenDeckart(
                            idDeckart = deckung.id,
                            deckartName = deckung.name,
                            deckartBeschreibung = deckung.beschreibung,
                            deckartBild = deckung.bildUrl
                        ),
                        snackbarHostState = snackbarHostState,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(deckung.beschreibung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Verwendung: ${deckung.verwendung.joinToString()}", style = schieferSecondaryStyle())
                Text("Schwierigkeitsgrad: ${deckung.schwierigkeitsgrad}", style = schieferSecondaryStyle())

                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
                Spacer(modifier = Modifier.height(8.dp))

                Text("📘 Beschreibung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(spitzwinkel.beschreibung, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🪨 Decksteinmodell", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                spitzwinkel.decksteinmodell.forEach {
                    Text("• $it", style = schieferBodyStyle())
                }

                Spacer(modifier = Modifier.height(12.dp))
                Text("🧱 Deckunterlage", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(spitzwinkel.deckunterlage, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🔩 Befestigung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(spitzwinkel.befestigung, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("📏 Überdeckung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(spitzwinkel.ueberdeckung.beschreibung, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("📐 Schnürrabstand-Formel", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(spitzwinkel.schnuerabstandFormel, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(8.dp))
                Text("🔣 Formel-Parameter", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text("• H: ${spitzwinkel.parameterErklaerung.h}", style = schieferBodyStyle())
                Text("• A: ${spitzwinkel.parameterErklaerung.a}", style = schieferBodyStyle())
                Text("• M: ${spitzwinkel.parameterErklaerung.m}", style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🏰 Ort, Grat & First", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text("• Traufe: ${spitzwinkel.ortGratFirst.traufe}", style = schieferBodyStyle())
                Text("• Ort: ${spitzwinkel.ortGratFirst.orte}", style = schieferSecondaryStyle())
                Text("• Grat: ${spitzwinkel.ortGratFirst.grate}", style = schieferSecondaryStyle())
                Text("• First: ${spitzwinkel.ortGratFirst.first}", style = schieferSecondaryStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📦 Maße & Stückzahlen", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
            }

            items(spitzwinkel.masseUndStueckzahlen) {
                Text("• Größe: ${it.groesseCm}", style = schieferBodyStyle())
                Text("  Nummer: ${it.nummers}", style = schieferSecondaryStyle())
                Text("  Mindest-Dachneigung: ${it.mindDachneigungGrad}", style = schieferSecondaryStyle())
                Text("  Bedarf: ${it.bedarfProM2} Stk/m²", style = schieferSecondaryStyle())
                Text("  Abschnitt: ${it.abschnittMm} mm", style = schieferSecondaryStyle())
                Text("  Gewicht: ${it.gewichtKg} kg", style = schieferSecondaryStyle())
                Text("  Kisteninhalt: ${it.kistenInhalt} Stk", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("🧮 Materialbedarf-Formel", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(spitzwinkel.materialbedarfFormel, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(8.dp))
                Text("🔣 Parameter Materialbedarf", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text("• L: ${spitzwinkel.parameterErklaerungMaterialbedarf.l}", style = schieferBodyStyle())
                Text("• A: ${spitzwinkel.parameterErklaerungMaterialbedarf.a}", style = schieferBodyStyle())
                Text("• Hs: ${spitzwinkel.parameterErklaerungMaterialbedarf.hs}", style = schieferBodyStyle())
                Text("• B: ${spitzwinkel.parameterErklaerungMaterialbedarf.b}", style = schieferBodyStyle())
            }
        }
    }
}