package com.example.schieferprofi.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.schieferprofi.R
import com.example.schieferprofi.util.Orientation


@Composable
fun SpiritLibelle(angle: Float, orientation: Orientation) {
    val maxTilt = 45f
    val bubbleSize = 36.dp
    val barLength = 400.dp
    val trackHeight = 56.dp

    val animatedOffset by animateFloatAsState(
        targetValue = (angle / maxTilt).coerceIn(-1f, 1f),
        label = "bubbleOffset"
    )

    Box(
        modifier = Modifier
            .size(
                width = if (orientation == Orientation.Horizontal) barLength else trackHeight,
                height = if (orientation == Orientation.Horizontal) trackHeight else barLength
            )
            .background(colorResource(R.color.hellgrau), shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRoundRect(color = Color(0xFF444444), cornerRadius = CornerRadius(16f, 16f))
        }

        Box(
            modifier = Modifier
                .size(bubbleSize)
                .offset {
                    val pxOffset = if (orientation == Orientation.Horizontal)
                        IntOffset((animatedOffset * 80).dp.roundToPx(), 0)
                    else
                        IntOffset(0, (animatedOffset * 80).dp.roundToPx())
                    pxOffset
                }
                .background(colorResource(R.color.hellgrau), shape = CircleShape)
                .shadow(6.dp, CircleShape)
        )


        Text(
            text = "${"%.1f".format(angle)}°",
            color = colorResource(R.color.ziegelrot),
            fontSize = 18.sp,
            modifier = Modifier
                .align(if (orientation == Orientation.Horizontal) Alignment.BottomCenter else Alignment.CenterEnd)
                .padding(4.dp)
        )
    }
}