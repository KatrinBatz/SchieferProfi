package com.example.schieferprofi.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.schieferprofi.R

@Composable
fun Background(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.schieferbackground),
        contentDescription = "BackgroundImage",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}