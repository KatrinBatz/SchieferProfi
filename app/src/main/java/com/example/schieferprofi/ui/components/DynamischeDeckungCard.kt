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
import androidx.compose.material3.DividerDefaults
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
import com.example.schieferprofi.data.model.DynamischeDeckungInfo
import com.example.schieferprofi.data.entity.FavoritenDeckart
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DynamischeDeckungCard(
    dynamisch: DynamischeDeckungInfo,
    deckung: Deckung,
    snackbarHostState: SnackbarHostState,
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
                        ),
                        snackbarHostState = snackbarHostState,
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
            }

            item {
                Text("Beschreibung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(dynamisch.beschreibung, style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Deckunterlage: ${dynamisch.deckunterlage}", style = schieferBodyStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Hinweis zur Überdeckung:", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(dynamisch.ueberdeckungHinweis, style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Hinweis zu Stoßfugen:", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(dynamisch.stosfugenHinweis, style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Hinweis zur Ortdeckung:", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(dynamisch.ortdeckungHinweis, style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(8.dp))
                Text("Deckbild-Hinweis:", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(dynamisch.deckbildHinweis, style = schieferSecondaryStyle())
                Spacer(modifier = Modifier.height(12.dp))
            }

            item {
                Text("Standardformate", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
            }
            items(dynamisch.standardformate) { format ->
                Text("• $format", style = schieferBodyStyle())
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("Befestigung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(10.dp))
                Text(dynamisch.befestigung.hinweis, style = schieferBodyStyle())
            }
            items(dynamisch.befestigung.befestigungNachBreite) { bef ->
                Text(
                    "• Maximale Breite: ${bef.maximaleBreite} mm, Befestigungsmittel: ${bef.befestigungsmittel}",
                    style = schieferSecondaryStyle()
                )
            }
        }
    }
}