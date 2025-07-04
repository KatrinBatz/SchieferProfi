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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.schieferprofi.data.model.LineareDeckungInfo
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun LineareCard(
    lineare: LineareDeckungInfo,
    deckung: Deckung,
    viewModel: FavoritenViewModel = koinViewModel()
) {
    val favoriten by viewModel.favoriten.collectAsState()

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

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 4.dp),
                    thickness = DividerDefaults.Thickness,
                    color = DividerDefaults.color
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text("📘 Beschreibung", style = schieferTitleStyle())
                Text(lineare.beschreibung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("🧱 Deckunterlage", style = schieferTitleStyle())
                Text(lineare.deckunterlage, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("🔩 Befestigung (sichtbar)", style = schieferTitleStyle())
                Text("• Material: ${lineare.befestigungSicht.material}", style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("🪛 Befestigung (unterlegt)", style = schieferTitleStyle())
                Text("• Mindestgröße für Haken: ${lineare.befestigungUnterlegt.minGroesseFuerHaken}", style = schieferBodyStyle())
                Text("• Blech-Hinweis: ${lineare.befestigungUnterlegt.blechHinweis}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("📏 Überdeckung", style = schieferTitleStyle())
                Text("• Stoßfugenbreite: ${lineare.ueberdeckung.stossfugeBreite}", style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("📦 Formate & Materialbedarf", style = schieferTitleStyle())
            }

            items(lineare.formate) { format ->
                Text("• Format: ${format.format}", style = schieferBodyStyle())
                Text("  Schieferbedarf: ${format.schieferbedarfProM2} Stück/m²", style = schieferSecondaryStyle())
                Text("  Hakenverbrauch: ${format.hakenverbrauchProM2} Stück/m²", style = schieferSecondaryStyle())
                Text("  Hakenlänge: ${format.hakenlaenge} mm", style = schieferSecondaryStyle())
                Text("  Lattenabstand: ${format.lattenabstand} cm", style = schieferSecondaryStyle())
                Text("  Lattenverbrauch: ${format.lattenverbrauchProM2} lfm/m²", style = schieferSecondaryStyle())
                Text("  Gewicht pro 1000 Stück: ${format.gewichtPro1000Stk} kg", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📝 Hinweis zum Materialbedarf", style = schieferTitleStyle())
                Text(lineare.materialbedarfHinweis, style = schieferBodyStyle())
            }
        }
    }
}