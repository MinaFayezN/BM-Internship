package dev.mina.internship.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.mina.internship.MainViewModel

@Composable
fun ListScreen(viewModel: MainViewModel) {
    var usersList by remember { mutableStateOf(viewModel.retrieveUsers()) }
    Greeting("Android $usersList")


    Button(onClick = {
//            viewModel.updateDatabase(name, email)
        usersList = viewModel.retrieveUsers()
    }) {
        Text(text = "Update list")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}