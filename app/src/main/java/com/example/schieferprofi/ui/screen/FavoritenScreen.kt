package com.example.schieferprofi.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.schieferprofi.R
import com.example.schieferprofi.ui.components.GlassmorphismCard
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferTitleStyle
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoritenScreen(viewModel: FavoritenViewModel = koinViewModel(), navController: NavController) {
    val favoriten by viewModel.favoriten.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.ladeFavoriten()
    }
    Box(modifier = Modifier.padding(16.dp)) {
        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Favoriten",
                    color = colorResource(R.color.hellgrau),
                    fontFamily = FontFamily(Font(R.font.ptserif_bolditalic)),
                    fontSize = 24.sp,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.align(Alignment.Center),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            if (favoriten.isEmpty()) {
                Text("Keine Favoriten vorhanden.", style = schieferBodyStyle())
            } else {
                LazyColumn {
                    items(favoriten) { deckart ->
                        GlassmorphismCard(
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable {
                                    navController.navigate("detail/${deckart.idDeckart}")
                                }
                        ) {
                            Column(Modifier.padding(16.dp)) {
                                Text(deckart.deckartName, style = schieferTitleStyle(),
                                    textDecoration = TextDecoration.Underline)
                                Text(
                                    deckart.deckartBeschreibung,
                                    style = schieferBodyStyle(),
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                AsyncImage(
                                    model = deckart.deckartBild,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(160.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Button(
                                    onClick = { viewModel.favoritenEntfernen(deckart.idDeckart) },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = colorResource(R.color.schiefergrau)
                                    ),
                                    modifier = Modifier.align(Alignment.End)
                                ) {
                                    Text("Entfernen")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}