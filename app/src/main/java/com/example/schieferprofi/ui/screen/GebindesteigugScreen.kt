package com.example.schieferprofi.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.schieferprofi.R
import com.example.schieferprofi.ui.components.GebindesteigungCard
import com.example.schieferprofi.ui.components.WerkzeugLadeAnimation
import com.example.schieferprofi.viewmodel.GebindesteigungViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun GebindesteigungScreen() {
    val gebindesteigungViewModel: GebindesteigungViewModel = koinViewModel()
    val gebindesteigung by gebindesteigungViewModel.gebindesteigung.collectAsState()
    val gebindesteigung1 by gebindesteigungViewModel.gebindesteigung1.collectAsState()
    val isLoading by gebindesteigungViewModel.isLoading.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Gebindesteigung",
                    color = colorResource(R.color.hellgrau),
                    fontFamily = FontFamily(Font(R.font.ptserif_bolditalic)),
                    fontSize = 24.sp,
                    textDecoration = TextDecoration.Underline
                )
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 16.dp)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                item {
                    if (isLoading) {
                        WerkzeugLadeAnimation()
                    } else {
                        GebindesteigungCard(
                            gebindesteigung = gebindesteigung,
                            gebindesteigung1 = gebindesteigung1
                        )
                    }
                }
            }
        }
    }
}