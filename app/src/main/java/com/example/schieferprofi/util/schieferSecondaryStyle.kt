package com.example.schieferprofi.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.schieferprofi.R

@Composable
fun schieferSecondaryStyle(
    fontSize: Int = 18,
    color: Color = colorResource(R.color.hellgrau)
) = TextStyle(
    color = color.copy(alpha = 0.7f),
    fontFamily = FontFamily(Font(R.font.ptserif_italic)),
    fontSize = fontSize.sp
)