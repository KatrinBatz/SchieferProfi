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
import com.example.schieferprofi.data.model.AltdeutscheDeckungInfo
import com.example.schieferprofi.data.model.Deckung
import com.example.schieferprofi.data.entity.FavoritenDeckart
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AltdeutschCard(
    altdeutsch: AltdeutscheDeckungInfo,
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

                Text("🪨 Deckstein-Regeln", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text("• Hiebarten: ${altdeutsch.decksteinRegeln.hiebarten.joinToString(", ")}", style = schieferBodyStyle())
                Text("• Befestigung Dach: ${altdeutsch.decksteinRegeln.befestigungDach}", style = schieferBodyStyle())
                Text("• Befestigung Wand: ${altdeutsch.decksteinRegeln.befestigungWand}", style = schieferBodyStyle())
                Text("• Bemerkung: ${altdeutsch.decksteinRegeln.bemerkung}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("📏 Sortierung – Sparren", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
            }
            items(altdeutsch.sortierung.sparren) { eintrag ->
                Text(
                    "• Höhe: ${eintrag.hoeheMeter}, Differenz: ${eintrag.differenzMm} mm, Sortierungen: ${eintrag.sortierungen}",
                    style = schieferBodyStyle()
                )
            }
            item {
                Text("📐 Sortierung – Wand", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
            }
            items(altdeutsch.sortierung.wand) { eintrag ->
                Text(
                    "• Höhe: ${eintrag.hoeheMeter}, Differenz: ${eintrag.differenzMm} mm, Sortierungen: ${eintrag.sortierungen}",
                    style = schieferBodyStyle()
                )
            }
            item { Spacer(modifier = Modifier.height(12.dp)) }

            item {
                Text("🏛️ Monumentum-Zuordnung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
            }
            items(altdeutsch.steinZuordnung.monumentum) { it ->
                Text("• Sortierung: ${it.sortierung}", style = schieferBodyStyle())
                Text("  Anfang Ort: ${it.anfangOrt}, Ende Ort: ${it.endOrt}", style = schieferSecondaryStyle())
                Text("  Kehlsteine: ${it.kehlsteine.joinToString(", ")}", style = schieferSecondaryStyle())
            }
            item {
                Text("🏗️ Intersin-Zuordnung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
            }
            items(altdeutsch.steinZuordnung.intersin) { it ->
                Text("• Sortierung: ${it.sortierung}", style = schieferBodyStyle())
                Text("  Anfang Ort: ${it.anfangOrt}, Ende Ort: ${it.endOrt}", style = schieferSecondaryStyle())
                Text("  Kehlsteine: ${it.kehlsteine.joinToString(", ")}", style = schieferSecondaryStyle())
            }
        }
    }
}