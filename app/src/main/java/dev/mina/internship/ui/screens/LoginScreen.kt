package dev.mina.internship.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import dev.mina.internship.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        var username: String by remember { mutableStateOf("") }
        var password: String by remember { mutableStateOf("") }
        var userError: Boolean by remember { mutableStateOf(false) }
        var passError: Boolean by remember { mutableStateOf(false) }
        var showPassword: Boolean by remember { mutableStateOf(false) }
        var isChecked: Boolean by remember { mutableStateOf(false) }
        var isValidated: Boolean by remember { mutableStateOf(false) }

        Image(
            modifier = Modifier.size(92.dp),
            painter = painterResource(id = R.drawable.user),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = username,
            label = { Text(text = "Username") },
            onValueChange = { newValue ->
                username = newValue
                if (username.isNotEmpty()) userError = false
            },
            trailingIcon = {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "")
            }
        )

        OutlinedTextField(
            value = password,
            label = { Text(text = "Password") },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            onValueChange = { newValue ->
                password = newValue
                if (password.isNotEmpty()) passError = false
            },
            trailingIcon = {
                IconButton(onClick = {
                    showPassword = showPassword.not()
                }) {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = "")
                }
            }
        )

        AnimatedVisibility(visible = userError) {
            Text(text = "Please Enter valid username")
        }
        AnimatedVisibility(passError) {
            Text(text = "Please Enter valid password")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                }
            )
            Text(text = "Remember Me!")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            colors = ButtonDefaults.buttonColors(),
            onClick = {
                if (username.isEmpty()) userError = true
                if (password.isEmpty()) passError = true
                isValidated = userError.not() && passError.not()
            }
        ) {
            Text(text = "Login")
        }

        AnimatedVisibility(visible = isValidated) {
            Text(text = "Hello $username ${if (isChecked) "Remembered" else ""}")
        }

    }
}