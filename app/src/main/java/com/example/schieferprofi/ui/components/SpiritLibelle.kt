package com.example.schieferprofi.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.schieferprofi.util.Orientation
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun SpiritLibelle(
    angle: Float,
    orientation: Orientation,
    modifier: Modifier = Modifier,
    maxTilt: Float = 45f,
    bubbleDiameter: Dp = 60.dp,
    trackLength: Dp = 300.dp,
    trackThickness: Dp = 80.dp
) {
    // Normalize angle to 0..1 (0 = -maxTilt, 1 = +maxTilt)
    val normalized by animateFloatAsState(
        targetValue = ((angle + maxTilt) / (2 * maxTilt)).coerceIn(0f, 1f),
        label = "bubblePosition"
    )

    // Convert dimensions to pixels
    val density = LocalDensity.current
    val bubblePx = with(density) { bubbleDiameter.toPx() }
    val mainTrackPx = with(density) { trackLength.toPx() }
    val crossTrackPx = with(density) { trackThickness.toPx() }

    // Compute travel range on the main axis
    val travelRange = mainTrackPx - bubblePx

    // Offset in pixels: centered at 0
    val offsetPx = (normalized * travelRange) - (travelRange / 2)

    Box(
        modifier = modifier
            .size(
                width = if (orientation == Orientation.Horizontal) trackLength else trackThickness,
                height = if (orientation == Orientation.Horizontal) trackThickness else trackLength
            )
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFEFEFEF), Color(0xFFCCCCCC)),
                    start = Offset.Zero,
                    end = if (orientation == Orientation.Horizontal)
                        Offset(mainTrackPx, 0f)
                    else
                        Offset(0f, mainTrackPx)
                ),
                shape = RoundedCornerShape(percent = 50)
            ),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val tickCount = 9
            for (i in 0..tickCount) {
                val fraction = i / tickCount.toFloat()
                val (x, y) = if (orientation == Orientation.Horizontal) {
                    size.width * fraction to size.height / 2
                } else {
                    size.width / 2 to size.height * fraction
                }
                val length = if (i == tickCount / 2) 12.dp.toPx() else 6.dp.toPx()
                if (orientation == Orientation.Horizontal) {
                    drawLine(
                        color = Color.DarkGray,
                        start = Offset(x, (size.height - length) / 2),
                        end = Offset(x, (size.height + length) / 2),
                        strokeWidth = 2.dp.toPx()
                    )
                } else {
                    drawLine(
                        color = Color.DarkGray,
                        start = Offset((size.width - length) / 2, y),
                        end = Offset((size.width + length) / 2, y),
                        strokeWidth = 2.dp.toPx()
                    )
                }
            }
        }

        // Bubble
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(bubbleDiameter)
                .offset {
                    if (orientation == Orientation.Horizontal) {
                        IntOffset(offsetPx.toInt(), 0)
                    } else {
                        IntOffset(0, offsetPx.toInt())
                    }
                }
                .shadow(8.dp, CircleShape)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(Color.White, Color(0xFFAAAAAA)),
                        center = Offset(bubblePx / 3, bubblePx / 3),
                        radius = bubblePx
                    ),
                    shape = CircleShape
                )
        ) {
            // Angle text inside bubble
            Text(
                text = "${"%.1f".format(angle)}°",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}