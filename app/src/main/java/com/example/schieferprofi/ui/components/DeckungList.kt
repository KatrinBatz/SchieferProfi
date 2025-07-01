package com.example.schieferprofi.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.schieferprofi.R
import com.example.schieferprofi.data.model.Deckung

@Composable
fun DeckungList(
    deckungen: List<Deckung>,
    onDeckungClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
//    val deckungsViewModel: DeckungViewModel = koinViewModel()
//    val deckungen by deckungsViewModel.deckungen.collectAsState()

    LazyColumn(modifier = modifier.fillMaxWidth().padding(horizontal = 12.dp)) {
        items(
            items = deckungen,
            key = { it.id }
        ) { deckung ->
            DeckungCard(
                deckung = deckung,
                onClick = { onDeckungClick(deckung.id) }
            )
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp,
                color = colorResource(R.color.hellgrau).copy(alpha = 0.2f)
            )
        }
    }
}

