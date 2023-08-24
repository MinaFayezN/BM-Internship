package dev.mina.internship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import dev.mina.internship.ui.theme.BMInternshipTheme
import dev.mina.internship.ui.theme.TS_MainTitle_OpenSans

class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMInternshipTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    var showDialog by remember { mutableStateOf(false) }
                    Button(onClick = {
                        showDialog = true
                    }) {
                        Text(text = "Dialog")
                    }
                    if (showDialog) {
                        FullScreenDialog(onDismiss = { /*TODO*/ }) {

                            Text(text = "Dialog")
                        }
                    }


                    var textValue by remember { mutableStateOf("") }

                    OutlinedTextField(
                        value = textValue,
                        onValueChange = { textValue = it },
                        label = {
                            Text(text = "Username")
                        }
                    )

                    val fromList = viewModel.fromCurrencyList.collectAsState()
                    val fromListValue = viewModel.fromCurrencySelectedItem.collectAsState()
                    var fromMenuExpanded by remember { mutableStateOf(false) }
                    Box {      //view
                        Row(modifier = Modifier.clickable {
                            fromMenuExpanded = true
                        }) {
                            Text(text = fromListValue.value)
                        }
                        DropdownMenu(expanded = fromMenuExpanded,
                            onDismissRequest = { fromMenuExpanded = false }) {
                            repeat(fromList.value.size) {
                                DropdownMenuItem(text = {
                                    Text(
                                        text = fromList.value[it],
                                        style = TS_MainTitle_OpenSans.copy(fontWeight = FontWeight.Bold)
                                    )
                                }, onClick = {
                                    fromMenuExpanded = false
                                    viewModel.updateFromSelected(fromList.value[it])
                                })
                            }
                        }
                    }


                    // on compare click -> hide screen 1 show screen 2
                    Greeting("Android")
                    var screen1 by remember { mutableStateOf(false) }
                    Row(modifier = Modifier) {

                        Button(onClick = { screen1 = true }) {
                            Text(text = "Screen 1")
                        }
                        Button(onClick = { screen1 = false }) {
                            Text(text = "Screen 2")
                        }
                    }

                    Box(
                        modifier = Modifier
                            .background(Color.Gray)
                            .fillMaxWidth()
                            .weight(1F)
                    ) {


                        if (screen1) {
                            Screen1()
                        } else {
                            Screen2()
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Screen1() {
    Box(modifier = Modifier.fillMaxSize().background(Color.Green))
}

@Composable
fun Screen2() {
    Box(modifier = Modifier.fillMaxSize().background(Color.Black))
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