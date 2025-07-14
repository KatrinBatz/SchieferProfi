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
import com.example.schieferprofi.data.model.Deckung
import com.example.schieferprofi.data.model.DynamischeRechteckDoppeldeckungInfo
import com.example.schieferprofi.data.entity.FavoritenDeckart
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DynamischeRechteckDoppeldeckungCard(
    dynamischeRechteck: DynamischeRechteckDoppeldeckungInfo,
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
            item {
                Text("Beschreibung", style = schieferTitleStyle())
                Text(dynamischeRechteck.beschreibung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Deckunterlage: ${dynamischeRechteck.deckunterlage}", style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Deckbild: ${dynamischeRechteck.deckbild}", style = schieferBodyStyle())
                Text("Verlegeschema: ${dynamischeRechteck.verlegeschema}", style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Dachneigungs-Hinweis: ${dynamischeRechteck.dachneigungHinweis}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(12.dp))
            }
            item {
                Text("Befestigung", style = schieferTitleStyle())
                Text("Dach: ${dynamischeRechteck.befestigung.dach}", style = schieferBodyStyle())
                Text("Ort/Grat: ${dynamischeRechteck.befestigung.ortGrat}", style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))
            }
            item {
                Text("Höhenüberdeckung", style = schieferTitleStyle())
                // Hier kannst du info.hoehenueberdeckung ggf. als Map ausgeben
                // Zum Beispiel, falls es key-value-pairs gibt:
                // info.hoehenueberdeckung.map.forEach { (key, value) -> ... }
            }
            item {
                Text("Fugenversatz: ${dynamischeRechteck.fugenversatz} mm", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(12.dp))
            }
            item {
                Text("Formate", style = schieferTitleStyle())
            }
            items(dynamischeRechteck.formate) { format ->
                Text("• Steinhöhe: ${format.steinhoehe} mm", style = schieferBodyStyle())
                Text("  Gebindehöhen: ${format.gebindehoehe.joinToString()}", style = schieferSecondaryStyle())
                Text("  Formate: ${format.formate.joinToString()}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}