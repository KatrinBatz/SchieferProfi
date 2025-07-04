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
import com.example.schieferprofi.data.model.VariableDeckungInfo
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle

@Composable
fun VariableCard(variable: VariableDeckungInfo, deckung: Deckung) {
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
                Text(variable.beschreibung, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🧱 Deckunterlage", style = schieferTitleStyle())
                Text(variable.deckunterlage, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🔩 Befestigung", style = schieferTitleStyle())
                Text(variable.befestigung.alternativeBefestigungHinweis, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("📏 Überdeckung", style = schieferTitleStyle())
                Text(variable.ueberdeckung.ueberdeckungHinweis, style = schieferBodyStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📐 Formate", style = schieferTitleStyle())
            }

            items(variable.formate) {
                Text("• Format: ${it.format}", style = schieferBodyStyle())
                Text("  Sichtbares Format: ${it.sichtbaresFormat}", style = schieferSecondaryStyle())
                Text("  Schieferbedarf: ${it.schieferbedarfProM2} Stk/m²", style = schieferSecondaryStyle())
                Text("  Schnürabstand: ${it.schnuerabstand} cm", style = schieferSecondaryStyle())
                Text("  Gewicht pro 1000 Stk: ${it.gewichtPro1000Stk} kg", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("🏗️ Ortdeckung", style = schieferTitleStyle())
                Text(variable.ortdeckungHinweis, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("📎 Flächeneinteilung", style = schieferTitleStyle())
                Text(variable.flaecheneinteilungHinweis, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("📏 Schnürabstand Hinweis", style = schieferTitleStyle())
                Text(variable.schnuerabstandHinweis, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🔁 Kombinierbare Formate", style = schieferTitleStyle())
                Text(variable.kombinierbareFormateHinweis, style = schieferBodyStyle())
            }
        }
    }
}