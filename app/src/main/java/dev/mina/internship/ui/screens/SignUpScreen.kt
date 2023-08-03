package dev.mina.internship.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var fName by remember { mutableStateOf("") }
        var lName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var age by remember { mutableStateOf(0) }
        OutlinedTextField(
            value = fName,
            onValueChange = { fName = it },
            label = { Text(text = "First Name") })
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = lName,
            onValueChange = { lName = it },
            label = { Text(text = "Last Name") })
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") })
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = age.toString(),
            onValueChange = { age = it.toInt() },
            label = { Text(text = "Age") })
        Spacer(modifier = Modifier.height(4.dp))
        Button(onClick = {
            navController.navigate("Profile/$fName&$lName&$email&$age")
        }) {
            Text(text = "Register")
        }
    }
}

