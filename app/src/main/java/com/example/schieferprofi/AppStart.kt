package com.example.schieferprofi

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.schieferprofi.ui.components.DetailedDrawer
import com.example.schieferprofi.ui.screen.HomeScreen
import com.example.schieferprofi.ui.screen.LexikonScreen
import com.example.schieferprofi.ui.screen.PlanungshilfeScreen
import com.example.schieferprofi.ui.screen.QuizScreen
import com.example.schieferprofi.ui.screen.WinkelmesserScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppStart() {

    val navController = rememberNavController()

    DetailedDrawer(navController = navController) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent
        ) { innerPadding ->

            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("home") {
                    HomeScreen(
                        onNavigateToLexikon = { navController.navigate("lexikon") },
                        onNavigateToTilt = { navController.navigate("winkelmesser") },
                        onNavigateToPlanungshilfe = { navController.navigate("planung") },
                        onNavigateToQuiz = { navController.navigate("quiz") }
                    )
                }

                composable("lexikon") {
                    LexikonScreen()
                }

                composable("winkelmesser") {
                    WinkelmesserScreen()
                }

                composable("planung") {
                    PlanungshilfeScreen(onBackClick = { navController.popBackStack() })
                }

                composable("quiz") {
                    QuizScreen(onBackClick = { navController.popBackStack() })
                }
            }
        }
    }
}
