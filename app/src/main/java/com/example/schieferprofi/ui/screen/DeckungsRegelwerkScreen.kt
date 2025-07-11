package com.example.schieferprofi.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.schieferprofi.ui.components.DeckungsRegelwerkCard
import com.example.schieferprofi.viewmodel.DeckungsRegelwerkViewModel
import org.koin.androidx.compose.koinViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment

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
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn(modifier = Modifier.padding(horizontal = 12.dp)) {
                items(regelwerke) { regelwerk ->
                    DeckungsRegelwerkCard(regelwerk = regelwerk)
                }
            }
        }
    }
}