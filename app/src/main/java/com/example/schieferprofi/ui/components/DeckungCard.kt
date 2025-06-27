package com.example.schieferprofi.ui.components

import android.R.attr.top
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.schieferprofi.R
import com.example.schieferprofi.data.model.Deckung

@Composable
fun DeckungCard(deckung: Deckung) {

    GlassmorphismCard {
        Column(modifier = Modifier.padding(16.dp)) {
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
            Text(
                text = deckung.name, color = colorResource(R.color.hellgrau),
                fontFamily = FontFamily(Font(R.font.ptserif_bolditalic)),
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = deckung.beschreibung, color = colorResource(R.color.hellgrau),
                fontFamily = FontFamily(Font(R.font.ptserif_italic)),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Verwendungsbereiche: ${deckung.verwendung}",
                color = colorResource(R.color.hellgrau),
                fontFamily = FontFamily(Font(R.font.ptserif_italic)),
                fontSize = 20.sp
            )
            Text(
                text = "Schwierigkeitsgrad: ${deckung.schwierigkeitsgrad}",
                color = colorResource(R.color.hellgrau),
                fontFamily = FontFamily(Font(R.font.ptserif_italic)),
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

