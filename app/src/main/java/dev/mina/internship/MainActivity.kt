package dev.mina.internship

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import dev.mina.internship.ui.MyText
import dev.mina.internship.ui.theme.BMInternshipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMInternshipTheme {
                Button(enabled = true, onClick = {
                    Log.d("OnClick", "Button onCLick event")
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_fav),
                        contentDescription = "Favourite icon",
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(14.dp))
                    MyText(title = "Add", isUnderline = false)
                    Spacer(modifier = Modifier.width(14.dp))
                    Divider(
                        modifier = Modifier
                            .width(20.dp)
                            .height(4.dp)
                    )
                    Spacer(modifier = Modifier.width(14.dp))
                    MyText(title = "to Fav", isUnderline = true)
                }


            }
        }
    }

    private fun sumNumbers(firstNo: Int, secondNo: Int) {

    }
}



