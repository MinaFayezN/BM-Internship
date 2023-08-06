package dev.mina.internship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.mina.internship.ui.screens.HomeScreen
import dev.mina.internship.ui.screens.SearchScreen
import dev.mina.internship.ui.theme.BMInternshipTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMInternshipTheme {
                val navController = rememberNavController()
                var selectedItem by remember { mutableStateOf("home") }
                val showNavigation = remember { mutableStateOf(true) }

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                if (currentRoute != null) {
                    selectedItem = currentRoute
                }

                Scaffold(
                    topBar = {
                        TopAppBar(
//                            colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.DarkGray),
                            navigationIcon = {
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Filled.Home,
                                        contentDescription = "Home"
                                    )
                                }
                            },
                            title = { Text(text = "Decoration App") },
                            actions = {
                                IconButton(onClick = {

                                }) {
                                    Icon(
                                        imageVector = Icons.Filled.Search,
                                        contentDescription = "Search"
                                    )
                                }
                                IconButton(onClick = {

                                }) {
                                    Icon(
                                        imageVector = Icons.Filled.Refresh,
                                        contentDescription = "Refresh"
                                    )
                                }
                            }
                        )
                    },
                    bottomBar = {
                        AnimatedVisibility(visible =showNavigation.value) {
                            BottomNavigaion(selectedItem, navController)
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = "Add")
                        }
                    }
                ) { paddingValues ->
                    Surface(modifier = Modifier.padding(paddingValues)) {
                        NavHost(navController, "home") {
                            composable("home") {
                                HomeScreen(showNavigation)
                            }
                            composable("search") {
                                SearchScreen()
                            }
                            composable("profile") {

                            }
                        }
                    }
                }

            }
        }
    }

    @Composable
    private fun BottomNavigaion(
        selectedItem: String,
        navController: NavHostController,
    ) {
        var selectedItem1 = selectedItem
        BottomAppBar {
            NavigationBarItem(
                selected = selectedItem1 == "home",
                onClick = {
                    selectedItem1 = "home"
                    navController.navigate(selectedItem1) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(imageVector = Icons.Filled.Home, contentDescription = "")
                },
                label = { if (selectedItem1 == "home") Text(text = "Home") }
            )
            NavigationBarItem(
                selected = selectedItem1 == "search",
                onClick = {
                    selectedItem1 = "search"
                    navController.navigate(selectedItem1) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = ""
                    )
                },
                label = {
                    if (selectedItem1 == "search")
                        Text(text = "Search")
                })
            NavigationBarItem(
                selected = selectedItem1 == "profile",
                onClick = {
                    selectedItem1 = "profile"
                    navController.navigate(selectedItem1) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true

                    }
                },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = ""
                    )
                },
                label = {
                    if (selectedItem1 == "profile")
                        Text(text = "Profile")
                })
        }
    }
}