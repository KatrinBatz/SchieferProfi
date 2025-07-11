package com.example.schieferprofi.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.schieferprofi.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedDrawer(
    navController: NavController,
    content: @Composable (PaddingValues) -> Unit

) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = colorResource(R.color.schiefergrau)
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(Modifier.height(12.dp))
                    Row{
                        Text("Schiefer Profi",
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.titleLarge,
                            color = colorResource(R.color.hellgrau),
                            fontFamily = FontFamily(Font(R.font.cormorant_bold)),
                            fontSize = 26.sp)
                        Image(
                            painter = painterResource(R.drawable.dachdeckerlogo),
                            contentDescription = "Schiefer Logo",
                            modifier = Modifier
                                .padding(16.dp)
                                .height(25.dp)
                                .clip(
                                    MaterialTheme.shapes.medium

                                )
                        )
                    }
                    HorizontalDivider()


                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Schiefer Lexikon",
                                fontFamily = FontFamily(Font(R.font.cormorant_bold)),
                                fontSize = 22.sp,
                                color = colorResource(R.color.hellgrau)
                            )
                        },
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate("lexikon")
                        }
                    )

                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Gebindesteigung",
                                fontFamily = FontFamily(Font(R.font.cormorant_bold)),
                                fontSize = 22.sp,
                                color = colorResource(R.color.hellgrau)
                            )
                        },
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate("gebindeteigung")
                        }
                    )

                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Deckungsregelwerk",
                                fontFamily = FontFamily(Font(R.font.cormorant_bold)),
                                fontSize = 22.sp,
                                color = colorResource(R.color.hellgrau)
                            )
                        },
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate("deckungsregelwerk")
                        }
                    )

                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Favoriten",
                                fontFamily = FontFamily(Font(R.font.cormorant_bold)),
                                fontSize = 22.sp,
                                color = colorResource(R.color.hellgrau)
                            )
                        },
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate("favoriten")
                        }
                    )

                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Winkelmesser",
                                fontFamily = FontFamily(Font(R.font.cormorant_bold)),
                                fontSize = 22.sp,
                                color = colorResource(R.color.hellgrau)
                            )
                        },
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate("winkelmesser")
                        }
                    )

                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = "Schiefer Quiz",
                                fontFamily = FontFamily(Font(R.font.cormorant_bold)),
                                fontSize = 22.sp,
                                color = colorResource(R.color.hellgrau)
                            )
                        },
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate("quiz")
                        }
                    )


                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {  },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                } else {
                                    drawerState.close()
                                }
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu",
                                tint = colorResource(R.color.ziegelrot)

                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(Color.Transparent)
                )
            },
            containerColor = Color.Transparent
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                content(innerPadding)

            }

        }
    }
}