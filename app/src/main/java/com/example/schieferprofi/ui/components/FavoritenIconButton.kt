package com.example.schieferprofi.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.colorResource
import com.example.schieferprofi.R
import com.example.schieferprofi.data.entity.FavoritenDeckart
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoritenIconButton(
    deckart: FavoritenDeckart,
    viewModel: FavoritenViewModel = koinViewModel()
) {
    val favoriten by viewModel.favoriten.collectAsState()

    val isFavorit = favoriten.any { it.idDeckart == deckart.idDeckart }
    val icon = if (isFavorit) Icons.Default.Star else Icons.Outlined.Star
    val tint = if (isFavorit) colorResource(R.color.ziegelrot) else colorResource(R.color.hellgrau)

    IconButton(onClick = { viewModel.toggleFavorit(deckart) }) {
        Icon(imageVector = icon, contentDescription = "Favorit", tint = tint)
    }
}