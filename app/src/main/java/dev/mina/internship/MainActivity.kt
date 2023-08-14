package dev.mina.internship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import dev.mina.internship.ui.screens.ListScreen
import dev.mina.internship.ui.screens.LoginScreen
import dev.mina.internship.ui.theme.BMInternshipTheme

class MainActivity : ComponentActivity() {

    val vm: MainViewModel by viewModels()

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContent {
            BMInternshipTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    LoginScreen(viewModel)

                    // Navigate
                    ListScreen(viewModel)
                }


            }
        }
    }


}

