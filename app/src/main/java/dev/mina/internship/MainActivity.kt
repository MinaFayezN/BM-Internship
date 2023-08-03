package dev.mina.internship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.mina.internship.ui.screens.HomeScreen
import dev.mina.internship.ui.screens.LoginScreen
import dev.mina.internship.ui.screens.ProfileScreen
import dev.mina.internship.ui.screens.SignUpScreen
import dev.mina.internship.ui.theme.BMInternshipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMInternshipTheme {
                // Place for handling multiple screens
//                val context = LocalContext.current
//                val navController by rememberSaveable { mutableStateOf(NavHostController(context)) }
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {

                    composable("login") {
                        LoginScreen(navController)
                    }
                    composable(
                        "home/{name}&{id}",
                        arguments = listOf(
                            navArgument("name") { type = NavType.StringType },
                            navArgument("id") { type = NavType.IntType },
                        )
                    ) {
                        val name = it.arguments?.getString("name") ?: "No Name added"
                        val id = it.arguments?.getInt("id")
                        HomeScreen(navController, name, id)
                    }
                    composable("register") {
                        SignUpScreen(navController)
                    }
                    composable(
                        route = "profile/{firstName}&{lastName}&{email}&{age}",
                        arguments = listOf(
                            navArgument("firstName") { type = NavType.StringType },
                            navArgument("lastName") { type = NavType.StringType },
                            navArgument("email") { type = NavType.StringType },
                            navArgument("age") { type = NavType.IntType },
                        )
                    ) { navBackStackEntry ->
                        val firstName =
                            navBackStackEntry.arguments?.getString("firstName") ?: "NoName"
                        val lastName =
                            navBackStackEntry.arguments?.getString("lastName") ?: "NoName"
                        val email = navBackStackEntry.arguments?.getString("email") ?: "NoEmail"
                        val age = navBackStackEntry.arguments?.getInt("age") ?: 0
                        ProfileScreen(
                            navController,
                            firstName,
                            lastName,
                            email,
                            age,
                        )
                    }

                }
            }
        }
    }
}