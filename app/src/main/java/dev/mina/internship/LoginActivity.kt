package dev.mina.internship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.mina.internship.ui.screens.Profile
import dev.mina.internship.ui.theme.BMInternshipTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMInternshipTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val profile = intent.getParcelableExtra("profile") as? Profile
//                    val mail = intent.extras?.getString("mail","")
                    Column(modifier = Modifier) {
                        Greeting2(profile?.name ?: "No Name")
                        val profiles = intent.getParcelableArrayExtra("profiles")

                        repeat(profiles?.size ?: 0) {
                            Greeting2((profiles?.get(it) as? Profile)?.name ?: "No Name")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    BMInternshipTheme {
        Greeting2("Android")
    }
}