package dev.mina.internship.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.mina.internship.ui.components.ButtonStyleDefaults
import dev.mina.internship.ui.components.MyButton

@Composable
fun HomeScreen(showNavigation: MutableState<Boolean>) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homeScreenList") {
        composable("homeScreenList") {
            HomeScreenList(navController, showNavigation)
        }
        composable(
            "innerHomeScreen/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            val id = it.arguments?.getInt("id") ?: -1
            InnerHomeScreen(navController, showNavigation,id)
        }


    }
}

@Composable
private fun HomeScreenList(
    navController: NavHostController,
    showNavigation: MutableState<Boolean>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        repeat(5) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(modifier = Modifier.clickable {
                navController.navigate("innerHomeScreen/$it")
            }, text = "Hello Team")
            MyButton(buttonStyle = ButtonStyleDefaults.mainButton)
            Divider(modifier = Modifier.height(2.dp))
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun InnerHomeScreen(
    navController: NavHostController,
    showNavigation: MutableState<Boolean>,
    id: Int
) {
    LaunchedEffect(Unit) {
        showNavigation.value = false
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Inner Screen for index: $id")
    }
    BackHandler {
        showNavigation.value = true
        navController.popBackStack()
    }
}