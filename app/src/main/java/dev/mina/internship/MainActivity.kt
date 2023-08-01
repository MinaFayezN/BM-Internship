package dev.mina.internship

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dev.mina.internship.ui.theme.BMInternshipTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMInternshipTheme {
                val calender = Calendar.getInstance()
                val year = calender.get(Calendar.YEAR)
                val month = calender.get(Calendar.MONTH) + 1
                val day = calender.get(Calendar.DAY_OF_MONTH)
                val hour = calender.get(Calendar.HOUR_OF_DAY)
                val minute = calender.get(Calendar.MINUTE)
                var showSnackBar by remember { mutableStateOf(false) }
                val selectedDate: MutableState<String> =
                    remember { mutableStateOf("$day/$month/$year") }
                val selectedTime: MutableState<String> =
                    remember { mutableStateOf("$hour:$minute") }
                var showDialog by remember { mutableStateOf(false) }
                val context = LocalContext.current
                Box(modifier = Modifier.fillMaxSize()) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {
                                Toast.makeText(context, "This is a toast", Toast.LENGTH_LONG).show()
                            }
                        ) {
                            Text(text = "Show Toast")
                        }

                        Button(
                            onClick = {
                                showSnackBar = true
                            }
                        ) {
                            Text(text = "Show Snackbar")
                        }

                        Button(
                            onClick = {
                                showDialog = true
                            }
                        ) {
                            Text(text = "Show Dialog")
                        }
                        Button(
                            onClick = {

                                showDatePicker(context, selectedDate, year, month, day)
                            }
                        ) {
                            Text(text = "Show Date Picker")
                        }
                        Text(text = "Selected data: ${selectedDate.value}")
                        Button(
                            onClick = {
                                showTimePicker(context, selectedTime, hour, minute)
                            }
                        ) {
                            Text(text = "Show Time Picker")
                        }
                        Text(text = "Selected time: ${selectedTime.value}")
                    }

                    if (showDialog)
                        AlertDialog(
                            title = {
                                Text(text = "Delete confirmation!")
                            },
                            text = {
                                Text(text = "Are you sure?!")
                            },
                            dismissButton = {
                                TextButton(onClick = {
                                    showDialog = false
                                }) {
                                    Text(text = "Cancel")
                                }

                            },
                            confirmButton = {
                                Button(onClick = {
                                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
                                    showDialog = false
                                }) {
                                    Text(text = "Confirm")
                                }
                            },
                            onDismissRequest = {
                                showDialog = false
                            }
                        )

                    AnimatedVisibility(
                        visible = showSnackBar,
                        modifier = Modifier.align(Alignment.BottomCenter)
                    ) {
                        Snackbar(
                            action = {
                                TextButton(onClick = {
                                    showSnackBar = false
                                }) {
                                    Text(text = "Dismiss")
                                }
                            }) {
                            Text(text = "asdasdaws")
                        }
                    }
                }
            }
        }
    }
}

fun showDatePicker(
    context: Context,
    selectedDate: MutableState<String>,
    year: Int,
    month: Int,
    day: Int,
) {
    val datePicker = DatePickerDialog(
        /*context*/ context,
        /*listener*/{ dataPicker, year, month, day ->
            selectedDate.value = "$day/${month + 1}/$year"
            Toast.makeText(context, selectedDate.value, Toast.LENGTH_SHORT).show()
        },
        /*year*/ year,
        /*month*/ month,
        /*day*/ day
    )
    datePicker.show()
}

fun showTimePicker(
    context: Context,
    selectedTime: MutableState<String>,
    hour: Int,
    minute: Int,
) {
    val timePicker = TimePickerDialog(
        /*context*/ context,
        /*listener*/ { dataPicker, hour, minute ->
            selectedTime.value = "$hour:$minute"
            Toast.makeText(context, selectedTime.value, Toast.LENGTH_SHORT).show()
        },
        /*hour*/ hour,
        /*minute*/ minute,
        /*is24Hour*/ true
    )
    timePicker.show()
}


@Preview(showBackground = true)
@Composable
fun Greeting() {
    Row(modifier = Modifier) {

        Text(
            text = "Hello!",
            modifier = Modifier
        )
        Text(
            text = "Hello!",
            modifier = Modifier
        )
        Text(
            text = "Hello!",
            modifier = Modifier
        )
        Text(
            text = "Hello!",
            modifier = Modifier
        )
        Text(
            text = "Hello!",
            modifier = Modifier
        )
        Text(
            text = "Hello!",
            modifier = Modifier
        )
        Spacer(modifier = Modifier.weight(1F))
//        Box(Modifier.weight(1f)) {
        Text(
            text = "Hello!",
            modifier = Modifier,/*.align(alignment = Alignment.CenterEnd)*/
        )
//        }
    }
}