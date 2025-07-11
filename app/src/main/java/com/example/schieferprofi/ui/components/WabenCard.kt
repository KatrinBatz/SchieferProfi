package com.example.schieferprofi.ui.components

import WabenDeckungInfo
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
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WabenCard(
    waben: WabenDeckungInfo,
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
                Text(waben.beschreibung, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🧱 Deckunterlage", style = schieferTitleStyle())
                Text(waben.deckunterlage, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🔩 Befestigung", style = schieferTitleStyle())
                Text(waben.befestigung, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🪨 Decksteinmodell", style = schieferTitleStyle())
                Text(waben.decksteinmodell, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🌀 Deckungsart", style = schieferTitleStyle())
                Text(waben.deckungsart, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("📏 Einteilung", style = schieferTitleStyle())
                Text("• Rechts-Links-Deckung: ${if (waben.einteilung.rechtsLinksdeckung) "Ja" else "Nein"}", style = schieferBodyStyle())
                Text("• Waagerecht: ${waben.einteilung.waagerecht} cm", style = schieferSecondaryStyle())
                Text("• Senkrecht: ${waben.einteilung.senkrecht} cm", style = schieferSecondaryStyle())
                Text("• Formel: ${waben.einteilung.schnuerabstandFormel}", style = schieferSecondaryStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🏗️ Ortdeckung", style = schieferTitleStyle())
                Text(waben.ortdeckung, style = schieferBodyStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📐 Formate", style = schieferTitleStyle())
            }

            items(waben.formate) {
                Text("• Format: ${it.breite} × ${it.hoehe} mm", style = schieferBodyStyle())
                Text("  Überdeckung: ${it.ueberdeckung} mm", style = schieferSecondaryStyle())
                Text("  Schieferbedarf: ${it.schieferbedarf} Stk/m²", style = schieferSecondaryStyle())
                Text("  Gewicht: ${it.gewichtPro1000Stk} kg/1000", style = schieferSecondaryStyle())
                Text("  Stück pro Kiste: ${it.stueckProKiste}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}