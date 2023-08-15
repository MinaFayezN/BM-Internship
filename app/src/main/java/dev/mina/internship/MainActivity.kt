package dev.mina.internship

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.mina.internship.ui.screens.LoginScreen
import dev.mina.internship.ui.theme.BMInternshipTheme
import kotlinx.coroutines.flow.collectLatest


class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMInternshipTheme {
                var usersList by
                remember { mutableStateOf(listOf<String>()) }
                viewModel.listLiveData.observe(this) {
                    Log.d("Livedata", it.toString())
                    // textView.text = it
                    if (it != null) {
                        usersList = it
                    }
                }
                LaunchedEffect(Unit) {
                    viewModel.listStateFlow.collectLatest {
                        Log.d("Livedata", it.toString())
//                        if (it != null) {
//                            usersList = it
//                        }
                    }
                }

//                val userListState = viewModel.listLiveData.observeAsState()
//                val userListState = viewModel.listStateFlow.collectAsState()

                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    LoginScreen(viewModel = viewModel)

                    Greeting(usersList.toString())
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
