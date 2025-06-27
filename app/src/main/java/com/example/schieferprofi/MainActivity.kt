package com.example.schieferprofi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import com.example.schieferprofi.ui.components.Background
import com.example.schieferprofi.ui.theme.SchieferProfiTheme
import com.example.schieferprofi.util.enableImmersiveMode

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableImmersiveMode()
        enableEdgeToEdge()
        setContent {

            Box(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
                Background()
                SchieferProfiTheme {
                    AppStart()
                }
            }
        }
    }
}

