package dev.mina.internship.ui.screens.login

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mina.internship.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var email: String by remember { mutableStateOf("") }
        var password: String by remember { mutableStateOf("") }
        var clicked: Boolean by remember { mutableStateOf(false) }
        var showPassword: Boolean by remember { mutableStateOf(false) }

        Image(
            modifier = Modifier.size(64.dp),
            painter = painterResource(id = R.drawable.user),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = email,
            label = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = { newValue ->
                email = newValue
                if (email.isEmpty()) clicked = false
            }
        )

        OutlinedTextField(
            value = password,
            label = { Text(text = "Password") },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            onValueChange = { newValue ->
                password = newValue
            },
            trailingIcon = {
                IconButton(onClick = {
                    showPassword = showPassword.not()
                }) {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = "")
                }
            }
        )

        Spacer(modifier = Modifier.height(12.dp))
        Button(
            colors = ButtonDefaults.buttonColors(),
            enabled = email.isNotEmpty(),
            onClick = {
                clicked = true
                Log.d("Click", "Clicked")
            }
        ) {
            Image(
                modifier = Modifier.size(12.dp),
                painter = painterResource(id = android.R.drawable.ic_input_add),
                contentDescription = ""
            )
            Text(text = "OK")
        }
        AnimatedVisibility(visible = clicked) {
            Text(text = "Hello $email")
        }

//        if (clicked) {
//            Text(text = "Hello $email")
//            Text(text = "Hello $email")
//            Text(text = "Hello $email")
//            Text(text = "Hello $email")
//            Text(text = "Hello $email")
//            Text(text = "Hello $email")
//            Text(text = "Hello $email")
//            Text(text = "Hello $email")
//            Text(text = "Hello $email")
//            Text(text = "Hello $email")
//        }
        Text(
            text = "Visible",
            Modifier.alpha(.5f),
            style = TextStyle(color = if (email.isNotEmpty()) Color.DarkGray else Color.Red)
        )
    }
}