package com.example.schieferprofi.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.schieferprofi.R
import com.example.schieferprofi.data.model.Deckung
import com.example.schieferprofi.util.schieferBodyStyle
import com.example.schieferprofi.util.schieferSecondaryStyle
import com.example.schieferprofi.util.schieferTitleStyle

@Composable
fun DeckungCard(
    deckung: Deckung,
    onClick: () -> Unit
) {

    GlassmorphismCard {
        Column(
            modifier = Modifier
                .clickable{ onClick() }
                .padding(16.dp)) {
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
                text = deckung.name,
                style = schieferTitleStyle(),
                textDecoration = TextDecoration.Underline
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = deckung.beschreibung,
                style = schieferBodyStyle(),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Verwendungsbereiche: ${deckung.verwendung.joinToString(", ")}",
                style = schieferSecondaryStyle()
            )
            Text(
                text = "Schwierigkeitsgrad: ${deckung.schwierigkeitsgrad}",
                style = schieferSecondaryStyle(),
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

