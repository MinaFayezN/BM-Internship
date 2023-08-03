package dev.mina.internship.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import dev.mina.internship.R

@Composable
fun ProfileScreen(
    navController: NavController,
    firstName: String,
    lastName: String,
    email: String,
    age: Int,
) {


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Login -> SignUp -> Profile  --- Login

        IconButton(onClick = {
            val navOptions = NavOptions.Builder().setPopUpTo("login", inclusive = true).build()
            navController.navigate("login", navOptions)
        }
        ) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
        }

        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "",
            modifier = Modifier
                .size(96.dp)
                .background(Color.LightGray)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = firstName,
                modifier = Modifier.padding(4.dp),
                style = TextStyle(color = Color.DarkGray)
            )
            Text(
                text = lastName,
                modifier = Modifier.padding(4.dp),
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }

        Text(
            text = "age: $age",
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "email: $email",
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            textAlign = TextAlign.Center
        )

    }


}