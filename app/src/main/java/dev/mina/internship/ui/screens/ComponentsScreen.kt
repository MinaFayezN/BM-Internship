package dev.mina.internship.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, device = Devices.PIXEL_4, name = "Phone")
@Preview(showBackground = true, device = Devices.NEXUS_7, name = "Tablet")
@Preview(showBackground = true, device = Devices.PIXEL_C, name = "Large Tablet")
@Composable
fun SliderDemo() {

    var sliderValue by remember { mutableStateOf(0.3f) }
    Column(
        Modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Slider(
            modifier = Modifier.padding(20.dp),
            value = sliderValue,
            onValueChange = {
                sliderValue = it
            }
        )

        Text(
            modifier = Modifier
                .alpha(sliderValue)
                .background(Color.LightGray)
                .padding(12.dp),
            text = "Hello Android!",
            style = TextStyle(fontSize = ((24 * sliderValue).sp))
        )

        LinearProgressDemo(sliderValue)
    }
}

@Preview(showBackground = true)
@Composable
fun LinearProgressDemo(progress: Float = 0.5f) {
    LinearProgressIndicator(modifier = Modifier.padding(24.dp), progress = progress)
}

@Preview(showBackground = true)
@Composable
fun DropDownDemo() {
    Row(modifier = Modifier.fillMaxWidth()) {


        var expanded by remember { mutableStateOf(false) }
        var selectedItem by remember { mutableStateOf("please select") }

        Row(modifier = Modifier
            .clickable {
                expanded = expanded.not()
            }
            .padding(12.dp)

            .clip(RoundedCornerShape(4.dp))
            .background(Color.LightGray)
            .padding(8.dp)) {
            Text(text = selectedItem)
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
        }

        DropdownMenu(
            modifier = Modifier.padding(horizontal = 12.dp),
            expanded = expanded,
            onDismissRequest = { expanded = false }) {
            repeat(5) {
                val text = "Menu Item $it"
                DropdownMenuItem(text = { Text(text = text) }, onClick = {
                    selectedItem = text
                    expanded = false
                })
                Divider(
                    Modifier
                        .height(2.dp)
                        .padding(bottom = 2.dp)
                )
            }
        }
    }
}

























