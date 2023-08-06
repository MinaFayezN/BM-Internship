package dev.mina.internship.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MyButton(buttonStyle: ButtonStyle) {
    Button(onClick = { /*TODO*/ }) {
        Text(text = buttonStyle.text)

        ///  .....
    }
}

data class ButtonStyle(
    val text: String,
    val trailingIcon: Int? = null,
    val leadingIcon: Int? =  null,
    val textColor: Color? = null,
)


object ButtonStyleDefaults{
    val mainButton = ButtonStyle(
        text = "maximus",
        trailingIcon = null,
        leadingIcon = null,
        textColor = null
    )

}