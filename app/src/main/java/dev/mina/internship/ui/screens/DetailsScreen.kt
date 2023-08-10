package dev.mina.internship.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
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
import androidx.navigation.NavHostController
import dev.mina.internship.ui.database.Profile
import dev.mina.internship.ui.database.ProfileDatabase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    database: ProfileDatabase,
    id: Int,
    navController: NavHostController,
    onBackClick: () -> Unit,
) {
    var profile by remember {
        mutableStateOf(getProfileFromDatabase(database, id))
    }
    var updatedName by remember { mutableStateOf(profile.name) }
    var updatedAge by remember { mutableStateOf(profile.age.toString()) }

    val showDialog = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Profile Details")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Name: ${profile.name}")
        Text(text = "Age: ${profile.age}")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = updatedName,
            onValueChange = { updatedName = it },
            label = { Text("Updated Name") }
        )
        OutlinedTextField(
            value = updatedAge,
            onValueChange = { updatedAge = it },
            label = { Text("Updated Age") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    showDialog.value = true
                }
            ) {
                Text(text = "Delete")
            }
            Button(
                onClick = {
                    updateProfileInDatabase(
                        database,
                        Profile(profile.id, updatedName, updatedAge.toInt())
                    )
                    profile = getProfileFromDatabase(database, id)
                }
            ) {
                Text(text = "Update")
            }
        }
    }
    if (showDialog.value) {
        DeleteProfileDialog(profile = profile) {
            it?.let {
                deleteProfileFromDatabase(database, it)
                onBackClick.invoke()
                navController.popBackStack()
            }
            showDialog.value = false
        }
    }
    BackHandler {
        onBackClick.invoke()
        navController.popBackStack()
    }
}


@Composable
fun DeleteProfileDialog(profile: Profile, onConfirmClick: (Profile?) -> Unit) {

    AlertDialog(
        onDismissRequest = { },
        title = { Text(text = "Delete Profile -> ${profile.name}") },
        text = {
            Text(text = "Are you sure!?")
        },
        confirmButton = {
            Button(
                onClick = {
                    onConfirmClick(profile)
                }
            ) {
                Text(text = "Yes")
            }
        },
        dismissButton = {
            Button(onClick = {
                onConfirmClick(null)
            }) {
                Text(text = "Cancel")
            }
        }
    )
}
