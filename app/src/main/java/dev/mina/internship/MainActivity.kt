package dev.mina.internship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import dev.mina.internship.room.MyDatabase
import dev.mina.internship.room.User
import dev.mina.internship.ui.theme.BMInternshipTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMInternshipTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    val context = LocalContext.current
                    val database = Room.databaseBuilder(
                        context,
                        MyDatabase::class.java,
                        "MyDatabase"
                    ).allowMainThreadQueries().build()
                    val userDao = database.userDao()


                    var data by remember { mutableStateOf("") }
                    var username by remember { mutableStateOf("") }
                    var age by remember { mutableStateOf("") }


                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                    ) {
                        Button(onClick = {
                            data = userDao.getALlUsers().joinToString(separator = "\n")
                        }) {
                            Text(text = "Retrieve Data")
                        }
                        Button(onClick = {
                            userDao.deleteUserManually("New Test User 4")
                        }) {
                            Text(text = "Delete last user")
                        }
                        Button(onClick = {
                            userDao.deleteUser(User(id = 48, name = "asd", age = 123))
                        }) {
                            Text(text = "Delete a user")
                        }
                        Button(onClick = {
                            userDao.updateUser(User(id = 49, name = "NEW ASD", age = 321))
                        }) {
                            Text(text = "Update a user")
                        }

                        OutlinedTextField(value = username, onValueChange = { username = it })
                        OutlinedTextField(
                            value = age,
                            onValueChange = { age = it.toIntOrNull()?.toString() ?: "" })
                        Button(onClick = {

                            age.toIntOrNull()?.let {
//                                val user = User(name = username, age = it)
                                val list = mutableListOf<User>()
                                repeat(5) {
                                    list.add(
                                        User(
                                            name = "New Test User $it",
                                            age = Random.nextInt()
                                        )
                                    )
                                }
//                                userDao.addUser(user = user)
                                userDao.addUserList(list)
                            }

                        }) {
                            Text(text = "Insert user")
                        }
                        Text(text = data)
                    }

                }
            }
        }
    }
}