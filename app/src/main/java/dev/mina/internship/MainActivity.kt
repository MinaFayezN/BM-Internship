package dev.mina.internship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
                    var age by remember { mutableStateOf(0) }




                    Column(modifier = Modifier.fillMaxSize()) {
                        Button(onClick = {
                            data = userDao.getALlUsers().joinToString(separator = "\n")
                        }) {
                            Text(text = "Retrieve Data")
                        }


                        OutlinedTextField(value = username, onValueChange = { username = it })
                        OutlinedTextField(
                            value = age.toString(),
                            onValueChange = { age = it.toInt() })
                        Button(onClick = {
                            val user = User(name = username, age = age)
                            val list = mutableListOf<User>()
                            repeat(5) {
                                userDao.addUser(user =User(name = "List name $it", age = Random.nextInt()))
//                                userDao.addUser(user = user)
                            }
//                            userDao.addUserList(list)
                            userDao.addUser(user = user)

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