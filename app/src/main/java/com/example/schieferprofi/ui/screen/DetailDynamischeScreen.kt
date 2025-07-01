package com.example.schieferprofi.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.example.schieferprofi.R
import com.example.schieferprofi.ui.components.DynamischeDeckungCard
import com.example.schieferprofi.viewmodel.DeckungViewModel
import com.example.schieferprofi.viewmodel.DynamischeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailDynamischeScreen(deckungId: String, navController: NavController) {
    val deckungViewModel: DeckungViewModel = koinViewModel()
    val dynamischeViewModel: DynamischeViewModel = koinViewModel()

    val deckungen by deckungViewModel.deckungen.collectAsState()
    val dynamische by dynamischeViewModel.dynamisch.collectAsState()
    val isLoading by dynamischeViewModel.isLoading.collectAsState()

    val deckung = deckungen.find { it.id == deckungId }

    Column(/*modifier = Modifier.padding(16.dp)*/) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                tint = colorResource(R.color.hellgrau),
                contentDescription = "Zurück"
            )
        }
        when {
            isLoading -> Text("Lade Details…")
            deckung == null -> Text("Deckung nicht gefunden!")
            else -> DynamischeDeckungCard(
                dynamisch = dynamische,
                deckung = deckung
            )
        }
    }
}