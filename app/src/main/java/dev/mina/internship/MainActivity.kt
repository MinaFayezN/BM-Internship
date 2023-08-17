package dev.mina.internship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import dev.mina.internship.room.User
import dev.mina.internship.ui.theme.BMInternshipTheme
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMInternshipTheme {
                // A surface container using the 'background' color from the theme
                val scope = rememberCoroutineScope()

                LaunchedEffect(key1 = Unit) {
                    viewModel.dataFlow.collectLatest {

                    }

                }

                val users = viewModel.users.collectAsState()
                var showDialog: Pair<Boolean, User?> by remember { mutableStateOf(true to null) }
                var asd: Triple<Boolean, User?, Int> by remember {
                    mutableStateOf(
                        Triple(
                            true,
                            null,
                            2
                        )
                    )
                }
                var name by remember { mutableStateOf("") }
                var age by remember { mutableStateOf("") }
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    item {
                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            label = { Text(text = "Name") }
                        )
                        OutlinedTextField(
                            value = age,
                            onValueChange = { age = it },
                            label = { Text(text = "Age") }
                        )
                        Button(onClick = {

                            val user = User(
                                name = name,
                                age = age.toInt()/* we need to check int value only*/
                            )
                            viewModel.saveData(user)

                        }) {
                            Text(text = "Save")
                        }
                    }
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Button(onClick = {
                                viewModel.retrieveUserList()
                            }) {
                                Text(text = "Retrieve Data")
                            }
                            Button(onClick = {
                                viewModel.deleteAllUsersAndRefresh(users.value)
                            }) {
                                Text(text = "Delete All Data")
                            }
                        }
                    }

                    items(users.value) { user ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .clickable {
                                    showDialog = true to user
                                }
                                .background(Color.LightGray),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(text = user.name)
                            Text(text = user.age.toString())
                        }

                    }
                }
                AnimatedVisibility(visible = showDialog.first) {
                    ShowDialog(showDialog.second) {
                        showDialog = false to null
                        viewModel.deleteUserAndRefresh(it)
                    }
                }
            }
        }
    }

    @Composable
    fun ShowDialog(user: User?, onDeleteClicked: (User) -> Unit) {
        user?.let {
            Dialog(onDismissRequest = { }) {
                Column(modifier = Modifier) {
                    Text(text = "Do you want to delete")
                    Button(onClick = {
                        onDeleteClicked.invoke(user)
                    }) {
                        Text(text = "Delete")
                    }
                }
            }
        }
    }
}
