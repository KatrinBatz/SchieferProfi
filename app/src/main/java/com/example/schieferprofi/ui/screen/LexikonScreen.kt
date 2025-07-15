package com.example.schieferprofi.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.schieferprofi.R
import com.example.schieferprofi.ui.components.DeckungList
import com.example.schieferprofi.ui.components.WerkzeugLadeAnimation
import com.example.schieferprofi.viewmodel.DeckungViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun LexikonScreen(navController: NavController) {

    val deckungsViewModel: DeckungViewModel = koinViewModel()
    val deckungen by deckungsViewModel.deckungen.collectAsState()
    val isLoading by deckungsViewModel.isLoading.collectAsState()


    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Schieferlexikon",
                    color = colorResource(R.color.hellgrau),
                    fontFamily = FontFamily(Font(R.font.ptserif_bolditalic)),
                    fontSize = 24.sp,
                    textDecoration = TextDecoration.Underline
                )
            }
            when {
                isLoading -> {
                    WerkzeugLadeAnimation()
                }

                else -> {
                    DeckungList(
                        deckungen = deckungen,
                        onDeckungClick = { id ->
                            Log.d("Deckung", "Clicked on deckung with id: $id")
                            navController.navigate("detail/$id")
                        }
                    )
                }
            }
        }
    }
}

