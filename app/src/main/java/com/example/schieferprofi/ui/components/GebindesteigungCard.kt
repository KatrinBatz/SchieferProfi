package com.example.schieferprofi.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil3.compose.AsyncImage
import com.example.schieferprofi.R
import com.example.schieferprofi.data.model.Gebindesteigung1Info
import com.example.schieferprofi.data.model.GebindesteigungInfo
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle

@Composable
fun GebindesteigungCard(
    gebindesteigung: GebindesteigungInfo,
    gebindesteigung1: Gebindesteigung1Info
) {
    var zoomImageUrl by remember { mutableStateOf<String?>(null) }
    val scrollState1 = rememberScrollState()

    GlassmorphismCard {
        Column(modifier = Modifier.padding(16.dp)) {

            Text("🔹 Rechnerisch", style = schieferSecondaryStyle())
            Text(gebindesteigung.erklaerungRechnerisch, style = schieferBodyStyle())
            Spacer(modifier = Modifier.height(8.dp))

            Text("🔹 Konstruktiv", style = schieferSecondaryStyle())
            Text(gebindesteigung.erklaerungKonstruktiv, style = schieferBodyStyle())
            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 4.dp),
                thickness = DividerDefaults.Thickness,
                color = DividerDefaults.color
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text("📊 Tabelle: Dachneigung → Mindest-Gebindesteigung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
            Spacer(modifier = Modifier.height(8.dp))

            AsyncImage(
                model = gebindesteigung.bildUrl,
                contentDescription = "Bild 1",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { zoomImageUrl = gebindesteigung.bildUrl }
                    .border(2.dp, colorResource(R.color.schiefergrau), RoundedCornerShape(12.dp))
                    .shadow(
                        elevation = 20.dp,
                        shape = RoundedCornerShape(12.dp),
                        clip = false
                    ),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 200.dp)
            ) {
                Column(modifier = Modifier.verticalScroll(scrollState1)) {
                    gebindesteigung.tabelle.forEach { eintrag ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Dachneigung: ${eintrag.dachneigung}°", style = schieferBodyStyle(), modifier = Modifier.weight(1f))
                            Text("Gmin: ${eintrag.mindestGebindesteigung}", style = schieferSecondaryStyle(), modifier = Modifier.weight(1f))
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp)
                        .align(Alignment.BottomCenter)
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    colorResource(R.color.schiefergrau).copy(alpha = 0.2f)
                                )
                            )
                        )
                )
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp),
                thickness = DividerDefaults.Thickness,
                color = DividerDefaults.color
            )

            Text("🪓 Hiebdeckarten: α → Steigung", style = schieferTitleStyle(), textDecoration = TextDecoration.Underline)
            Spacer(modifier = Modifier.height(8.dp))

            AsyncImage(
                model = gebindesteigung1.bildUrl,
                contentDescription = "Gebindesteigungs-Bild 2",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { zoomImageUrl = gebindesteigung1.bildUrl }
                    .border(2.dp, colorResource(R.color.schiefergrau), RoundedCornerShape(12.dp))
                    .shadow(
                        elevation = 20.dp,
                        shape = RoundedCornerShape(12.dp),
                        clip = false
                    ),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            gebindesteigung1.tabelle.forEach { eintrag ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(eintrag.hiebdeckart, style = schieferBodyStyle(), modifier = Modifier.weight(1f))
                    Text("α: ${eintrag.alpha}°", style = schieferSecondaryStyle(), modifier = Modifier.weight(0.5f))
                    Text("Steigung: ${eintrag.steigung} cm", style = schieferSecondaryStyle(), modifier = Modifier.weight(0.5f))
                }
            }
        }
    }

    zoomImageUrl?.let { imageUrl ->
        Dialog(onDismissRequest = { zoomImageUrl = null }) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.95f))
                    .clickable { zoomImageUrl = null },
                contentAlignment = Alignment.Center
            ) {
                ZoomableImage(
                    imageUrl = imageUrl,
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .fillMaxHeight(0.95f)
                )
            }
        }
    }
}