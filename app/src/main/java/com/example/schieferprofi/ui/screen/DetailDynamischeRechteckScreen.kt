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
import com.example.schieferprofi.ui.components.DynamischeRechteckDoppeldeckungCard
import com.example.schieferprofi.viewmodel.DeckartenViewModel
import com.example.schieferprofi.viewmodel.DeckungViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailDynamischeRechteckScreen(deckungId: String, navController: NavController) {
    val deckungViewModel: DeckungViewModel = koinViewModel()
    val dynamischViewModel: DeckartenViewModel = koinViewModel()

    val deckungen by deckungViewModel.deckungen.collectAsState()
    val info by dynamischViewModel.dynamischeRechteck.collectAsState()
    val isLoading by dynamischViewModel.isLoading.collectAsState()

    val deckung = deckungen.find { it.id == deckungId }

    Column {
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
            else -> DynamischeRechteckDoppeldeckungCard(info = info, deckung = deckung)
        }
    }
}