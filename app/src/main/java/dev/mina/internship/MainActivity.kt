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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mina.internship.ui.theme.BMInternshipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        startActivity(Intent(this, ViewActivity::class.java))
        setContent {
            BMInternshipTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier) {
                        Greeting("Android")
                        Greeting("Android")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true, device = Devices.PIXEL_4, widthDp = 300)
@Composable
fun GreetingPreview() {
    BMInternshipTheme {
        Column(modifier = Modifier) {
            Greeting("Android asd as.kjed ashjdgaslkd ajshd gASLKasd asd asd asd asd asd asd asdd dg alkhjsdg lakjsjd gk.a,jhsgd ")
            Greeting("")
            Greeting("Android 02")
            Greeting("Android 03")
            Greeting("Android")
            Greeting("Android")
            Greeting("Android")
            Greeting("Android")
        }
    }
}