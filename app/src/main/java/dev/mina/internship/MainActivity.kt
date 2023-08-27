package dev.mina.internship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mina.internship.ui.theme.BMInternshipTheme

class MainActivity : ComponentActivity() {


    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMInternshipTheme {
                val contacts = viewModel.contactsFlow.collectAsState()
                var expanded by remember { mutableStateOf(false) }
                Column(
                    modifier = Modifier.fillMaxSize(.5f),
                ) {
                    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {

                        Button(
                            modifier = Modifier.wrapContentSize(),
                            onClick = { expanded = true }) {
                            Text(text = "EGP")
                        }

                        DropdownMenu(
                            expanded = expanded,
                            modifier = Modifier.fillMaxWidth(.5f),
                            onDismissRequest = { expanded = false }) {

                            DropdownMenuItem(

                                text = { Text(text = "Item 01") },
                                onClick = { /*TODO*/ })
                            DropdownMenuItem(

                                text = { Text(text = "Item 01") },
                                onClick = { /*TODO*/ })
                            DropdownMenuItem(

                                text = { Text(text = "Item 01") },
                                onClick = { /*TODO*/ })
                            DropdownMenuItem(

                                text = { Text(text = "Item 01") },
                                onClick = { /*TODO*/ })
                            DropdownMenuItem(

                                text = { Text(text = "Item 01") },
                                onClick = { /*TODO*/ })
                        }
                    }
                    LazyColumn {
                        items(contacts.value?.contacts ?: listOf()) {
                            Column(modifier = Modifier) {
                                Text(text = it.name)
                                Text(text = it.email)
                                Text(text = it.companyName)
                                Divider(modifier = Modifier.height(4.dp))
                                Spacer(modifier = Modifier.height(4.dp))
                            }
                        }

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