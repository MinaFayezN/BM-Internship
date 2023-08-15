package dev.mina.internship.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.mina.internship.MainViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun LoginScreen(viewModel: MainViewModel) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var result: Boolean? by remember { mutableStateOf(null) }
    OutlinedTextField(
        value = name,
        label = { Text(text = "Name") },
        onValueChange = { name = it })
    OutlinedTextField(
        value = email,
        label = { Text(text = "Email") },
        onValueChange = { email = it })
    Button(onClick = {
     viewModel.updateDatabase(name, email)
    }) {
        Text(text = "Save")
    }

}
