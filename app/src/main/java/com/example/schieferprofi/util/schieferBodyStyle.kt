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
fun schieferBodyStyle(
    fontSize: Int = 20,
    color: Color = colorResource(R.color.hellgrau)
) = TextStyle(
    color = color,
    fontFamily = FontFamily(Font(R.font.ptserif_italic)),
    fontSize = fontSize.sp
)