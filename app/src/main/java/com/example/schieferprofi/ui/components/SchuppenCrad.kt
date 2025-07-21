package com.example.schieferprofi.ui.components

import FavoritenIconButton
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
import androidx.compose.material3.SnackbarHostState
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
import com.example.schieferprofi.data.model.SchuppenDeckungInfo
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SchuppenCard(
    schuppen: SchuppenDeckungInfo,
    deckung: Deckung,
    snackbarHostState: SnackbarHostState,
    viewModel: FavoritenViewModel = koinViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.ladeFavoriten()
    }

    GlassmorphismCard {
        LazyColumn(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {

            item {
                AsyncImage(
                    model = deckung.bildUrl,
                    contentDescription = "Bild von ${deckung.name}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(
                            2.dp,
                            colorResource(R.color.schiefergrau),
                            RoundedCornerShape(12.dp)
                        )
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
                        ),
                        snackbarHostState = snackbarHostState
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(deckung.beschreibung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Verwendung: ${deckung.verwendung.joinToString()}",
                    style = schieferSecondaryStyle()
                )
                Text(
                    "Schwierigkeitsgrad: ${deckung.schwierigkeitsgrad}",
                    style = schieferSecondaryStyle()
                )

                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    "📘 Beschreibung",
                    style = schieferTitleStyle(),
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(schuppen.beschreibung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    "🪨 Decksteinmodell(e)",
                    style = schieferTitleStyle(),
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.height(10.dp))
                schuppen.decksteinmodell.forEach {
                    Text("• $it", style = schieferBodyStyle())
                }

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "🧱 Deckunterlage",
                    style = schieferTitleStyle(),
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(schuppen.deckunterlage, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "🔩 Befestigung",
                    style = schieferTitleStyle(),
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text("• Dach: ${schuppen.befestigungDach}", style = schieferBodyStyle())
                Text("• Wand: ${schuppen.befestigungWand}", style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "📏 Überdeckungen",
                    style = schieferTitleStyle(),
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(schuppen.ueberdeckungen, style = schieferBodyStyle())

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "💡 Deckarten-Hinweis",
                    style = schieferTitleStyle(),
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(schuppen.deckartenHinweis, style = schieferBodyStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "📦 Maße für Dach",
                    style = schieferTitleStyle(),
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            items(schuppen.masseDach) {
                Text("• Höhe: ${it.hoehe}, Breite: ${it.breite}", style = schieferBodyStyle())
                Text("  Bedarf: ${it.bedarfProM2} Stk/m²", style = schieferSecondaryStyle())
                Text("  Überdeckung: ${it.ueberdeckung}", style = schieferSecondaryStyle())
                Text("  Neigung: ${it.geeignetFuerDachneigung}", style = schieferSecondaryStyle())
                Text("  Gewicht: ${it.kgPro1000} kg/1000", style = schieferSecondaryStyle())
                Text("  Stück pro Kiste: ${it.stueckProKiste}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "📏 Maße für Wand",
                    style = schieferTitleStyle(),
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            items(schuppen.masseWand) {
                Text("• Höhe: ${it.hoehe}, Breite: ${it.breite}", style = schieferBodyStyle())
                Text("  Bedarf: ${it.bedarfProM2} Stk/m²", style = schieferSecondaryStyle())
                Text(
                    "  Seitenüberdeckung: ${it.seitenueberdeckung} mm",
                    style = schieferSecondaryStyle()
                )
                Text(
                    "  Höhenüberdeckung: ${it.hoehenueberdeckung} mm",
                    style = schieferSecondaryStyle()
                )
                Text("  Gewicht: ${it.kgPro1000} kg/1000", style = schieferSecondaryStyle())
                Text("  Stück pro Kiste: ${it.stueckProKiste}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "📌 Zuordnung",
                    style = schieferTitleStyle(),
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            items(schuppen.zuordnung) {
                Text("• Größe: ${it.schuppengroesse}", style = schieferBodyStyle())
                Text("  Ort: ${it.anfangOrt} → ${it.endOrt}", style = schieferSecondaryStyle())
                Text(
                    "  Kehlsteine: ${it.kehlsteine.joinToString()}",
                    style = schieferSecondaryStyle()
                )
                Text("  Fersenversatz: ${it.fersenversatz}", style = schieferSecondaryStyle())
                Text("  Rohsortierung: ${it.rohsortierung}", style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "🧮 Rechenbeispiel",
                    style = schieferTitleStyle(),
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(schuppen.rechenbeispiel, style = schieferBodyStyle())
            }
        }
    }
}