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
import com.example.schieferprofi.data.model.UniversalDeckungInfo
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UniversalCard(
    universal: UniversalDeckungInfo,
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
                Text(universal.beschreibung, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🪨 Decksteinmodell(e)", style = schieferTitleStyle())
                universal.decksteinmodell.forEach {
                    Text("• $it", style = schieferBodyStyle())
                }

                Spacer(modifier = Modifier.height(12.dp))
                Text("🧱 Deckunterlage", style = schieferTitleStyle())
                Text(universal.deckunterlage, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🔩 Befestigung", style = schieferTitleStyle())
                Text("• Dach: ${universal.befestigungDach}", style = schieferBodyStyle())
                Text("• Wand: ${universal.befestigungWand}", style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🦶 Fußdeckung", style = schieferTitleStyle())
                Text(universal.fussdeckung, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🏰 Ort, Grat & First", style = schieferTitleStyle())
                Text(universal.ortGratFirst, style = schieferBodyStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📐 Formate Wand", style = schieferTitleStyle())
            }

            items(universal.formateWand) {
                Text("• Bedarf: ${it.bedarfProM2} Stk/m²", style = schieferBodyStyle())
                Text("  Lattenabstand: ${it.lattenabstandCm} cm", style = schieferSecondaryStyle())
                Text("  Lattenverbrauch: ${it.lattenverbrauchM} lfm/m²", style = schieferSecondaryStyle())
                Text("  Gewicht: ${it.gewichtPro1000} kg/1000", style = schieferSecondaryStyle())
                Text("  Stück pro Kiste: ${it.stkProKiste}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📏 Formate Hochformat", style = schieferTitleStyle())
            }

            items(universal.formateHochformat) {
                Text("• Größe: ${it.groesse}", style = schieferBodyStyle())
                Text("  Bedarf: ${it.bedarfProM2} Stk/m²", style = schieferSecondaryStyle())
                Text("  Abstand waagerecht: ${it.waagerecht} cm", style = schieferSecondaryStyle())
                Text("  Abstand senkrecht: ${it.senkrecht} cm", style = schieferSecondaryStyle())
                Text("  Gewicht: ${it.gewichtPro1000} kg/1000", style = schieferSecondaryStyle())
                Text("  Stück pro Kiste: ${it.stkProKiste}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("📎 Gleichort-Gebinde", style = schieferTitleStyle())
                Text(universal.gleichortGebindeInfo, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text("🏗️ Ortdeckung", style = schieferTitleStyle())
                Text(universal.ortdeckung, style = schieferBodyStyle())
            }
        }
    }
}