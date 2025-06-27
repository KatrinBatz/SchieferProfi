package com.example.schieferprofi.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.schieferprofi.R
import com.example.schieferprofi.viewmodel.DeckungViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DeckungList(modifier: Modifier = Modifier) {
    val deckungsViewModel: DeckungViewModel = koinViewModel()
    val deckungen by deckungsViewModel.deckungen.collectAsState()

    LazyColumn(modifier = modifier.fillMaxWidth().padding(horizontal = 12.dp)) {
        items(
            items = deckungen,
            key = { it.id }
        ) { deckung ->
            DeckungCard(deckung = deckung)
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
                color = colorResource(R.color.hellgrau).copy(alpha = 0.2f),
                thickness = 1.dp
            )
        }
    }
}

