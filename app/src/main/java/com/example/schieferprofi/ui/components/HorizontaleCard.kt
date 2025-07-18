package com.example.schieferprofi.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
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
import com.example.schieferprofi.data.model.HorizontaleDeckungInfo
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HorizontaleCard(
    horizontale: HorizontaleDeckungInfo,
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
                        )
                    )
                }
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

                Text("📘 Beschreibung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(horizontale.beschreibung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("🧱 Deckunterlage", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(horizontale.deckunterlage, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("🖼️ Deckbild", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(horizontale.deckbild, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("🔩 Befestigung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(horizontale.befestigung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("📏 Mindest-Höhenüberdeckung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text("${horizontale.mindestHoehenueberdeckung} mm", style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("✅ Vorteile", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                horizontale.vorteile.forEach { vorteil ->
                    Text("• $vorteil", style = schieferBodyStyle())
                }
                Spacer(modifier = Modifier.height(12.dp))

                Text("📦 Formate & Materialbedarf", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
            }
            items(horizontale.formate) { format ->
                Text("• Format: ${format.format}", style = schieferBodyStyle())
                Text("  Schieferbedarf: ${format.schieferbedarfProM2} Stück/m²", style = schieferSecondaryStyle())
                Text("  Hakenverbrauch: ${format.hakenverbrauchProM2} Stück/m²", style = schieferSecondaryStyle())
                Text("  Lattenabstand: ${format.lattenabstandCm} cm", style = schieferSecondaryStyle())
                Text("  Lattenverbrauch: ${format.lattenverbrauchProM2} lfm/m²", style = schieferSecondaryStyle())
                Text("  Gewicht pro 1000 Stück: ${format.gewichtPro1000Stk} kg", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}