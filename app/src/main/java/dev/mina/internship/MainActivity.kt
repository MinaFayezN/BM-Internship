package dev.mina.internship

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dev.mina.internship.ui.screens.MainScreen
import dev.mina.internship.ui.screens.Profile
import dev.mina.internship.ui.theme.BMInternshipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMInternshipTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(::navigateToLogin)
                }
            }
        }
    }


    private fun navigateToLogin(profile: Profile) {
        val bundle = Bundle()
        bundle.putParcelable("profile", profile)
        val list = listOf(profile, profile, profile)
        bundle.putParcelableArray("profiles", list.toTypedArray())
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

}
