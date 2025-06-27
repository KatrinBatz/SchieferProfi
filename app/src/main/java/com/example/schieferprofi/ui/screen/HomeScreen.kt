package com.example.schieferprofi.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
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
    onNavigateToPlanungshilfe: () -> Unit,
    onNavigateToQuiz: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Willkommen",
                fontFamily = FontFamily(Font(R.font.cormorant_bold)),
                fontSize = 22.sp,
                color = colorResource(R.color.hellgrau),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Hier findest du alles zum Thema Schiefer – von Deckungsarten bis zur Planung.",
                fontFamily = FontFamily(Font(R.font.cormorant_regular)),
                fontSize = 22.sp,
                color = colorResource(R.color.hellgrau),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            androidx.compose.material3.Button(onClick = onNavigateToLexikon) {
                Text("📘 Lexikon")
            }

            androidx.compose.material3.Button(onClick = onNavigateToTilt) {
                Text("📐 Winkelmesser")
            }

            androidx.compose.material3.Button(onClick = onNavigateToPlanungshilfe) {
                Text("📐 Planungshilfe")
            }

//            androidx.compose.material3.Button(onClick = onNavigateToBilderkennung) {
//                Text("📷 Bilderkennung")
//            }

            androidx.compose.material3.Button(onClick = onNavigateToQuiz) {
                Text("🎓 Quiz")
            }
        }
    }
}