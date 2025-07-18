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
import com.example.schieferprofi.data.model.VariableDeckungInfo
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun VariableCard(
    variable: VariableDeckungInfo,
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
                HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
                Spacer(modifier = Modifier.height(8.dp))

                Text("📘 Beschreibung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(variable.beschreibung, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🧱 Deckunterlage", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(variable.deckunterlage, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🔩 Befestigung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(variable.befestigung.alternativeBefestigungHinweis, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("📏 Überdeckung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(variable.ueberdeckung.ueberdeckungHinweis, style = schieferBodyStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📐 Formate", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
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
                Text("🏗️ Ortdeckung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(variable.ortdeckungHinweis, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("📎 Flächeneinteilung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(variable.flaecheneinteilungHinweis, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("📏 Schnürabstand Hinweis", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(variable.schnuerabstandHinweis, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🔁 Kombinierbare Formate", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(variable.kombinierbareFormateHinweis, style = schieferBodyStyle())
            }
        }
    }
}