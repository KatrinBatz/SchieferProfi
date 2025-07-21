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
import com.example.schieferprofi.data.model.WaagerechteDeckungInfo
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WaagerechteCard(
    waagerecht: WaagerechteDeckungInfo,
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
                Text(waagerecht.beschreibung, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🧱 Deckunterlage", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(waagerecht.deckunterlage, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🖼️ Deckbild", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(waagerecht.deckbild, style = schieferBodyStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("🔩 Befestigung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
            }

            items(waagerecht.befestigung) {
                Text("• Format: ${it.format}", style = schieferBodyStyle())
                Text("  Schrauben: ${it.schrauben}", style = schieferSecondaryStyle())
                Text("  Haken: ${it.haken}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📏 Überdeckung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text("• Höhenüberdeckung: ${waagerecht.ueberdeckung.hoehenueberdeckung} mm", style = schieferBodyStyle())
                Text("• Seitenüberdeckung: ${waagerecht.ueberdeckung.seitenueberdeckung} mm", style = schieferBodyStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📦 Materialbedarf", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
            }

            items(waagerecht.materialbedarf) {
                Text("• Format: ${it.format}", style = schieferBodyStyle())
                Text("  Sichtbare Größe: ${it.sichtbareGroesse}", style = schieferSecondaryStyle())
                Text("  Bedarf: ${it.schieferbedarf} Stk/m²", style = schieferSecondaryStyle())
                Text("  Gewicht: ${it.gewichtPro1000Stk} kg/1000", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("🧷 Hakenbedarf", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
            }

            items(waagerecht.hakenbedarf) {
                Text("• Format: ${it.format}", style = schieferBodyStyle())
                Text("  Hakenverbrauch: ${it.hakenverbrauch} Stk/m²", style = schieferSecondaryStyle())
                Text("  Lattenabstand: ${it.lattenabstand} cm", style = schieferSecondaryStyle())
                Text("  Lattenverbrauch: ${it.lattenverbrauch} lfm/m²", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("🧮 Bedarfsformel", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text("• Formel: ${waagerecht.bedarfsformel.formel}", style = schieferBodyStyle())
                Text("• Rechenbeispiel: ${waagerecht.bedarfsformel.rechenbeispiel}", style = schieferSecondaryStyle())
            }
        }
    }
}