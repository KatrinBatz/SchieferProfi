package com.example.schieferprofi.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DividerDefaults
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
import com.example.schieferprofi.data.model.BogenschnittDeckungInfo
import com.example.schieferprofi.data.model.Deckung
import com.example.schieferprofi.data.model.FavoritenDeckart
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun BogenschnittCard(
    bogenschnitt: BogenschnittDeckungInfo,
    deckung: Deckung,
    viewModel: FavoritenViewModel = koinViewModel()
    ) {

    LaunchedEffect(Unit) {
        viewModel.ladeFavoriten()
    }

    GlassmorphismCard {
        LazyColumn(
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        ) {
            // Kopfbereich mit Bild & Basisdaten
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
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 4.dp),
                    thickness = DividerDefaults.Thickness,
                    color = DividerDefaults.color
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Bogenschnitt spezifisch
            item {
                Text("Beschreibung", style = schieferTitleStyle())
                Text(bogenschnitt.beschreibung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Decksteinmodell: ${bogenschnitt.decksteinmodell.joinToString()}", style = schieferBodyStyle())
                Text("Deckunterlage: ${bogenschnitt.deckunterlage}", style = schieferBodyStyle())
                Text("Befestigung Dach: ${bogenschnitt.befestigungDach}", style = schieferBodyStyle())
                Text("Befestigung Wand: ${bogenschnitt.befestigungWand}", style = schieferBodyStyle())
                Text("Fußdeckung: ${bogenschnitt.fussdeckung}", style = schieferBodyStyle())
                Text("Ort/Grat/First: ${bogenschnitt.ortGratFirst}", style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))
            }

            item { Text("Formate Wand", style = schieferTitleStyle()) }
            items(bogenschnitt.formateWand) { format ->
                Text("• Größe: ${format.groesse}", style = schieferBodyStyle())
                Text("  Höhenüberdeckung: ${format.hoehenUeberdeckung} mm, Seitenüberdeckung: ${format.seitenUeberdeckung} mm", style = schieferSecondaryStyle())
                Text("  Bedarf pro m²: ${format.bedarfProM2}, Lattenabstand: ${format.lattenabstandCm} cm", style = schieferSecondaryStyle())
                Text("  Lattenverbrauch: ${format.lattenverbrauchM} m, Gewicht pro 1000: ${format.gewichtPro1000} kg", style = schieferSecondaryStyle())
                Text("  Stück pro Kiste: ${format.stkProKiste}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item { Text("Ort-Zuordnung", style = schieferTitleStyle()) }
            items(bogenschnitt.ortZuordnung) { ort ->
                Text("• Format: ${ort.format}", style = schieferBodyStyle())
                Text("  Höhenüberdeckung: ${ort.hoehenUeberdeckung} mm", style = schieferSecondaryStyle())
                Text("  Anfang Ort: ${ort.anfangort}, Ende Ort: ${ort.endort}", style = schieferSecondaryStyle())
                Text("  Stück pro Meter: ${ort.stkProM}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item { Text("Kehl-Material", style = schieferTitleStyle()) }
            items(bogenschnitt.kehlMaterial) { kehl ->
                Text("• Sortierung: ${kehl.sortierung}", style = schieferBodyStyle())
                Text("  Maße: ${kehl.masse}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}