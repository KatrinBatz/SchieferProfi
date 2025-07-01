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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.schieferprofi.R
import com.example.schieferprofi.data.model.Deckung
import com.example.schieferprofi.data.model.DynamischeRechteckDoppeldeckungInfo
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle

@Composable
fun DynamischeRechteckDoppeldeckungCard(
    info: DynamischeRechteckDoppeldeckungInfo,
    deckung: Deckung
) {
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
                        .shadow(
                            elevation = 20.dp,
                            shape = RoundedCornerShape(12.dp),
                            clip = false
                        ),
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
            }
            item {
                Text("Beschreibung", style = schieferTitleStyle())
                Text(info.beschreibung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Deckunterlage: ${info.deckunterlage}", style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Deckbild: ${info.deckbild}", style = schieferBodyStyle())
                Text("Verlegeschema: ${info.verlegeschema}", style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Dachneigungs-Hinweis: ${info.dachneigungHinweis}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(12.dp))
            }
            item {
                Text("Befestigung", style = schieferTitleStyle())
                Text("Dach: ${info.befestigung.dach}", style = schieferBodyStyle())
                Text("Ort/Grat: ${info.befestigung.ortGrat}", style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))
            }
            item {
                Text("Höhenüberdeckung", style = schieferTitleStyle())
                // Hier kannst du info.hoehenueberdeckung ggf. als Map ausgeben
                // Zum Beispiel, falls es key-value-pairs gibt:
                // info.hoehenueberdeckung.map.forEach { (key, value) -> ... }
            }
            item {
                Text("Fugenversatz: ${info.fugenversatz} mm", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(12.dp))
            }
            item {
                Text("Formate", style = schieferTitleStyle())
            }
            items(info.formate) { format ->
                Text("• Steinhöhe: ${format.steinhoehe} mm", style = schieferBodyStyle())
                Text("  Gebindehöhen: ${format.gebindehoehe.joinToString()}", style = schieferSecondaryStyle())
                Text("  Formate: ${format.formate.joinToString()}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}