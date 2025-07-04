package com.example.schieferprofi.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.schieferprofi.R

@Composable
fun HomeScreen(
    onNavigateToLexikon: () -> Unit,
    onNavigateToTilt: () -> Unit,
    onNavigateToFavoriten: () -> Unit,
    onNavigateToQuiz: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
//            .padding(32.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.schieferbackground1),
            contentDescription = "BackgroundImage",
            modifier = Modifier.fillMaxSize(1f),
            contentScale = ContentScale.FillBounds
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "SchieferProfi – Dein Begleiter fürs Dachhandwerk",
                fontFamily = FontFamily(Font(R.font.cormorant_bold)),
                fontSize = 26.sp,
                color = colorResource(R.color.hellgrau),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Die App vereint ein umfangreiches Schieferdeckungs-Lexikon mit Bildern und Fachinfos, eine Favoritenfunktion für schnellen Zugriff, einen integrierten Winkelmesser zur Neigungsbestimmung und ein interaktives Quiz, um dein Wissen spielerisch zu testen.",
                fontFamily = FontFamily(Font(R.font.cormorant_regular)),
                fontSize = 22.sp,
                color = colorResource(R.color.hellgrau),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

//            androidx.compose.material3.Button(onClick = onNavigateToLexikon) {
//                Text("📘 Lexikon")
//            }
//
//            androidx.compose.material3.Button(onClick = onNavigateToTilt) {
//                Text("📐 Winkelmesser")
//            }
//
//            androidx.compose.material3.Button(onClick = onNavigateToFavoriten) {
//                Text("⭐️ Favoriten")
//            }
//
////            androidx.compose.material3.Button(onClick = onNavigateToBilderkennung) {
////                Text("📷 Bilderkennung")
////            }
//
//            androidx.compose.material3.Button(onClick = onNavigateToQuiz) {
//                Text("🎓 Quiz")
//            }
        }
    }
}