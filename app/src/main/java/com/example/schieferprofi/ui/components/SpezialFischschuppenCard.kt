package com.example.schieferprofi.ui.components

import androidx.compose.foundation.border
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
import com.example.schieferprofi.data.model.SpezialFischschuppeDeckungInfo
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SpezialFischschuppeCard(
    fischschuppen: SpezialFischschuppeDeckungInfo,
    deckung: Deckung,
    viewModel: FavoritenViewModel = koinViewModel()
    ) {
    GlassmorphismCard {
        val favoriten by viewModel.favoriten.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.ladeFavoriten()
        }

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
                HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
                Spacer(modifier = Modifier.height(8.dp))

                Text("📘 Beschreibung", style = schieferTitleStyle())
                Text(fischschuppen.beschreibung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text("🪨 Decksteinmodell", style = schieferTitleStyle())
                Text(fischschuppen.decksteinmodell, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🧱 Deckunterlage", style = schieferTitleStyle())
                Text(fischschuppen.deckunterlage, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🔩 Befestigung", style = schieferTitleStyle())
                Text("• Allgemein: ${fischschuppen.befestigung.allgemein}", style = schieferBodyStyle())
                Text("• Ausnahme: ${fischschuppen.befestigung.ausnahme}", style = schieferSecondaryStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("📏 Überdeckungen", style = schieferTitleStyle())
                Text("• Hinweis: ${fischschuppen.ueberdeckungHinweis}", style = schieferBodyStyle())
                Text("• Mindest-Höhenüberdeckung: ${fischschuppen.mindesthoehenueberdeckung} mm", style = schieferSecondaryStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🏰 Ort und First", style = schieferTitleStyle())
                Text(fischschuppen.ortUndFirstHinweis, style = schieferBodyStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📐 Steinformate", style = schieferTitleStyle())
            }

            items(fischschuppen.steinformatTabelle) {
                Text("• Breite: ${it.breite} mm, Höhe: ${it.hoehe} mm", style = schieferBodyStyle())
                Text("  Schnürrabstand: ${it.schnürrabstand} cm", style = schieferSecondaryStyle())
                Text("  Schieferbedarf: ${it.schieferbedarfProM2} Stk/m²", style = schieferSecondaryStyle())
                Text("  Gewicht: ${it.gewichtPro1000} kg/1000", style = schieferSecondaryStyle())
                Text("  Stück pro Kiste: ${it.stueckProKiste}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("🧮 Materialbedarf-Hinweis", style = schieferTitleStyle())
                Text(fischschuppen.materialbedarfHinweis, style = schieferBodyStyle())
            }
        }
    }
}