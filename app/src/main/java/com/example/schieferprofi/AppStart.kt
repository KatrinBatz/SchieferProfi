package com.example.schieferprofi

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.schieferprofi.data.model.GebindesteigungInfo
import com.example.schieferprofi.ui.components.DetailedDrawer
import com.example.schieferprofi.ui.screen.FavoritenScreen
import com.example.schieferprofi.ui.screen.GebindesteigungScreen
import com.example.schieferprofi.ui.screen.HomeScreen
import com.example.schieferprofi.ui.screen.LexikonScreen
import com.example.schieferprofi.ui.screen.PlanungshilfeScreen
import com.example.schieferprofi.ui.screen.QuizScreen
import com.example.schieferprofi.ui.screen.WinkelmesserScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailAltdeutschScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailBogenschnittScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailDynamischeRechteckScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailDynamischeScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailGeschlaufteScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailGezogeneScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailHorizontaleScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailKettengebindeScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailLineareScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailRechteckDoppelScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailSchuppenScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailSpezialFischschuppenScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailSpitzwinkelScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailUniversalScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailUnterlegteScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailVariableScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailWaagerechteScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailWabenScreen
import com.example.schieferprofi.ui.screen.detailscreen.DetailWildeScreen


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
                        onNavigateToFavoriten = { navController.navigate("favoriten") },
                        onNavigateToQuiz = { navController.navigate("quiz") }
                    )
                }

                composable("lexikon") {
                    LexikonScreen(navController)
                }

                composable("gebindeteigung") {
                    GebindesteigungScreen(
                        navController = navController
                    )
                }

                composable("winkelmesser") {
                    WinkelmesserScreen()
                }

                composable("favoriten") {
                    FavoritenScreen(
                        navController = navController
                    )
                }

                composable("quiz") {
                    QuizScreen(onBackClick = { navController.popBackStack() })
                }

                composable(
                    route = "detail/{deckungId}",
                    arguments = listOf(navArgument("deckungId") { type = NavType.StringType })
                ) { backStackEntry ->
                    val deckungId = backStackEntry.arguments?.getString("deckungId") ?: ""
                    when (deckungId) {
                        "altdeutsche" -> DetailAltdeutschScreen(deckungId, navController)
                        "bogenschnitt" -> DetailBogenschnittScreen(deckungId, navController)
                        "dynamische" -> DetailDynamischeScreen(deckungId, navController)
                        "dynamische-rechteck-doppeldeckung" -> DetailDynamischeRechteckScreen(deckungId, navController)
                        "geschlaufte" -> DetailGeschlaufteScreen(deckungId, navController)
                        "gezogene" -> DetailGezogeneScreen(deckungId, navController)
                        "horizontale" -> DetailHorizontaleScreen(deckungId, navController)
                        "kettengebinde" -> DetailKettengebindeScreen(deckungId, navController)
                        "lineare" -> DetailLineareScreen(deckungId, navController)
                        "rechteck-doppeldeckung" -> DetailRechteckDoppelScreen(deckungId, navController)
                        "schuppen" -> DetailSchuppenScreen(deckungId, navController)
                        "spezial-fischschuppen" -> DetailSpezialFischschuppenScreen(deckungId, navController)
                        "spitzwinkel" -> DetailSpitzwinkelScreen( deckungId, navController)
                        "universal" -> DetailUniversalScreen(deckungId, navController)
                        "unterlegte" -> DetailUnterlegteScreen(deckungId, navController)
                        "variable" -> DetailVariableScreen(deckungId, navController)
                        "waben" -> DetailWabenScreen(deckungId, navController)
                        "waagerechte" -> DetailWaagerechteScreen(deckungId, navController)
                        "wilde-rechteck-doppeldeckung" -> DetailWildeScreen(deckungId, navController)

                        else -> Text("Detail nicht gefunden!")
                    }
                }
            }
        }
    }
}
