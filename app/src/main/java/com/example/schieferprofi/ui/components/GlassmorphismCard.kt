package com.example.schieferprofi.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.schieferprofi.R

@Composable
fun GlassmorphismCard(
    modifier: Modifier = Modifier,
    blurRadius: Dp = 0.1.dp,
    backgroundColor: Color  = colorResource(R.color.hellgrau).copy(alpha = 0.1f),
    cornerRadius: Dp = 16.dp,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .background(backgroundColor)
            .blur(blurRadius)
            .padding(16.dp)
    ) {
        content()
    }
}