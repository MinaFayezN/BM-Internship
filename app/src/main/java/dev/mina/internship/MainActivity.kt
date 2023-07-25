package dev.mina.internship

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.mina.internship.ui.theme.BMInternshipTheme

class MainActivity : ComponentActivity() {

    var name = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val result =
            savedInstanceState?.let {
                "with Bundle ${it.getString("Name", "No Name Found")}"
            } ?: "with No Bundle"
        Log.d("LifeCycle", "onCreate called Activity 01 $result")
        setContent {
            BMInternshipTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", modifier = Modifier.clickable {
                        name = "New name"
                        startActivity(Intent(this, ViewActivity::class.java))
                    })
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "onStart called Activity 01")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "onResume called Activity 01")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "onPause called Activity 01")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "onStop called Activity 01")
    }


    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycle", "onRestart called Activity 01")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "onDestroy called Activity 01")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("LifeCycle", "onSaveInstanceState called Activity 01")
        outState.putString("Name", "My Name"/* get string from user input field */)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMInternshipTheme {
        Greeting("Android")
    }
}