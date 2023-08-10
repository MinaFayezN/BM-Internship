package dev.mina.internship.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import dev.mina.internship.ui.database.Profile
import dev.mina.internship.ui.database.ProfileDatabase


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ListScreen(
    database: ProfileDatabase,
    list: List<Profile>,
    navController: NavHostController,
    onAddItem: () -> Unit,
) {
    val showDialog = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Profiles") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog.value = true }
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add Profile")
            }
        },
    ) { paddingValues ->

        LazyColumn(modifier = Modifier.padding(paddingValues)) {

            if (list.isEmpty()) {
                item {
                    Text(text = "No Profile Saved")
                }
            } else {
                items(list) { profile ->
                    ProfileItem(profile = profile) {
                        navController.navigate("ProfileDetails/${profile.id}")
                    }
                }
            }
        }

    }
    if (showDialog.value) {
        AddProfileDialog { profile ->
            profile?.let {
                saveProfileToDatabase(database, it)
                onAddItem.invoke()
            }
            showDialog.value = false
        }
    }
}


@Composable
fun ProfileItem(profile: Profile, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Text(
            text = profile.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProfileDialog(onSaveClick: (Profile?) -> Unit) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { },
        title = { Text(text = "Add Profile") },
        text = {
            Column {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(text = "Name") }
                )
                Spacer(modifier = Modifier.height(2.dp))
                TextField(
                    value = age,
                    onValueChange = { age = it },
                    label = { Text(text = "Age") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onSaveClick(Profile(name = name, age = age.toInt()))
                }
            ) {
                Text(text = "OK")
            }
        },
        dismissButton = {
            Button(onClick = {
                onSaveClick(null)
            }) {
                Text(text = "Cancel")
            }
        }
    )
}
