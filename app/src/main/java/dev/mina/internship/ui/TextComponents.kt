package dev.mina.internship.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mina.internship.ui.theme.MainColor
import dev.mina.internship.ui.theme.TS_MainTitle

@Preview(name = "ALl Custom Text Components", showBackground = true)
@Composable
fun AlLTextComponentsPreview() {
    Column(modifier = Modifier) {
        MyText("No Underline Text", color = Color.Blue)
        Spacer(modifier = Modifier.height(4.dp))
        MyText("Underlined Text", true, Color.Red)
    }
}

@Composable
fun MyText(title: String, isUnderline: Boolean = false, color: Color = Color.Unspecified) {
    Text(
        text = title,
        style = TextStyle(
            textDecoration = if (isUnderline) TextDecoration.Underline else TextDecoration.None,
            color = color
        )
    )
}

@Composable
fun MainComponent() {
    Text(
        modifier = Modifier
            .sizeIn(minHeight = 200.dp, maxHeight = 500.dp)
            .background(MainColor)
            .border(width = 2.dp, color = Color.Blue)
//            .padding(15.dp)
//            .padding(vertical = 15.dp)
//            .border(width = 2.dp, color = Color.Blue)
//            .padding(15.dp)
//            .border(width = 2.dp, color = Color.Blue)
//            .padding(15.dp)
//            .border(width = 2.dp, color = Color.Blue)
            .padding(15.dp),
        text = retrieveTitle(),// Utils.callAPI.getName()
        style = TS_MainTitle,
    )
}

private fun retrieveTitle(): String {
    //
    //
    //
    //
    return ""
}