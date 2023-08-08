package dev.mina.internship

import android.content.Context
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import dev.mina.internship.db.MyDatabaseHelper
import dev.mina.internship.ui.theme.BMInternshipTheme

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
                    Column(modifier = Modifier) {
                        var username by remember { mutableStateOf("") }
                        var users by remember { mutableStateOf("") }
                        var userAge by remember { mutableStateOf(0) }
                        OutlinedTextField(label = {
                            Text(text = "Username")
                        },
                            value = username,
                            onValueChange = { username = it })
                        OutlinedTextField(label = {
                            Text(text = "Age")
                        },
                            value = userAge.toString(),
                            onValueChange = { userAge = it.toInt() })

                        Button(onClick = {
                            val databaseHelper = MyDatabaseHelper(context)
                            val isInserted = databaseHelper.insertUserData(username, userAge)
                            Toast.makeText(
                                context,
                                "Data ${if (isInserted) "Inserted Successfully" else "Insertion Error"}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }) {
                            Text(text = "Save Data")
                        }
                        Button(onClick = {
                            val databaseHelper = MyDatabaseHelper(context)
                            val list = databaseHelper.getAllNames()
                            Toast.makeText(
                                context,
                                list.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }) {
                            Text(text = "Retrieve All Data")
                        }
                        Button(onClick = {
                            val databaseHelper = MyDatabaseHelper(context)
                            val list = databaseHelper.retrieveNamesWithMinimumAge(0)
                            users = list.joinToString("\n")
                            Toast.makeText(
                                context,
                                list.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }) {
                            Text(text = "Retrieve Data")
                        }

                        Button(onClick = {
                            val databaseHelper = MyDatabaseHelper(context)
                            val isUpdated = databaseHelper.updateUserData(1, "New Name", 33)
                            Toast.makeText(context, isUpdated.toString(), Toast.LENGTH_SHORT).show()
                        }) {
                            Text(text = "Update Data")
                        }
                        Button(onClick = {
                            val databaseHelper = MyDatabaseHelper(context)
                            val isDeleted = databaseHelper.deleteUserDataWithMinimumAge(5)
                            Toast.makeText(context, isDeleted.toString(), Toast.LENGTH_SHORT).show()
                        }) {
                            Text(text = "Delete Data")
                        }
                        Text(text = users)
                    }
                }
            }
        }
    }

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SharedPreferencesDemo(context: Context) {
    Column(modifier = Modifier.fillMaxSize()) {

        var result by remember { mutableStateOf("") }
        var username by remember { mutableStateOf("") }
        //
        //
        TextField(value = username, onValueChange = { username = it })

        Button(onClick = {
            /*
                        API calls
                        return results
                       decide if logged in or not
                         */

            val sharedPreferences =
                context.getSharedPreferences("credentials", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLoggedIn", username.isNotBlank())
            editor.putString("username", username)
            editor.apply()

        }) {
            Text(text = "Save Login result")
        }
        Button(onClick = {
            val sharedPreferences =
                context.getSharedPreferences("credentials", Context.MODE_PRIVATE)
            val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

            result = if (isLoggedIn)
                "user already logged in"
            else
                "user did not log in before"


        }) {
            Text(text = "Retrieve Login result")
        }
        Text(text = result)
    }
}
