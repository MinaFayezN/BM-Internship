package dev.mina.internship.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room
import dev.mina.internship.ui.database.ProfileDatabase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val context = LocalContext.current
    val db =
        Room.databaseBuilder(context, ProfileDatabase::class.java, "profile_database")
            .allowMainThreadQueries().build()

    val navController = rememberNavController()
    var list by remember { mutableStateOf(getAllProfilesFromDatabase(db)) }

    NavHost(navController = navController, "ListScreen") {
        composable("ListScreen") {
            ListScreen(db, list, navController) {
                list = getAllProfilesFromDatabase(db)
            }
        }
        composable(
            "ProfileDetails/{profileID}",
            arguments = listOf(navArgument("profileID") { type = NavType.IntType })
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt("profileID") ?: -1
            DetailsScreen(database = db, id = id, navController) {
                list = getAllProfilesFromDatabase(db)
            }
        }
    }

}
