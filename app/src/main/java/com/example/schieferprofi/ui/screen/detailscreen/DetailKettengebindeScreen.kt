package com.example.schieferprofi.ui.screen.detailscreen

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
import com.example.schieferprofi.ui.components.KettengebindeCard
import com.example.schieferprofi.viewmodel.DeckartenViewModel
import com.example.schieferprofi.viewmodel.DeckungViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailKettengebindeScreen(deckungId: String, navController: NavController) {
    val deckungViewModel: DeckungViewModel = koinViewModel()
    val deckartenViewModel: DeckartenViewModel = koinViewModel()

    val deckungen by deckungViewModel.deckungen.collectAsState()
    val kettengebinde by deckartenViewModel.kettengebinde.collectAsState()
    val isLoading by deckartenViewModel.isLoading.collectAsState()

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
            else -> KettengebindeCard(kettengebinde = kettengebinde, deckung = deckung)
        }
    }
}