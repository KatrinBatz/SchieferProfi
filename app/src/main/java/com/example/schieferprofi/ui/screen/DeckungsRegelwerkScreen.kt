package com.example.schieferprofi.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.schieferprofi.R
import com.example.schieferprofi.ui.components.DeckungsRegelwerkCard
import com.example.schieferprofi.ui.components.WerkzeugLadeAnimation
import com.example.schieferprofi.viewmodel.DeckungsRegelwerkViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DeckungsRegelwerkScreen() {
    val viewModel: DeckungsRegelwerkViewModel = koinViewModel()
    val regelwerke by viewModel.deckungsRegelwerk.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Deckungsregelwerk",
                    color = colorResource(R.color.hellgrau),
                    fontFamily = FontFamily(Font(R.font.ptserif_bolditalic)),
                    fontSize = 24.sp,
                    textDecoration = TextDecoration.Underline
                )
            }
            if (isLoading) {
                WerkzeugLadeAnimation()
            } else {
                LazyColumn(modifier = Modifier.padding(horizontal = 12.dp)) {
                    items(regelwerke) { regelwerk ->
                        DeckungsRegelwerkCard(regelwerk = regelwerk)
                    }
                }
            }
        }
    }
}