package dev.mina.internship.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BoxComponent() {

    Box(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
    ) {
        Text(text = "Hello Android 01", modifier = Modifier.align(Alignment.BottomEnd))
        Text(text = "Hello Team 02", modifier = Modifier.align(Alignment.Center))
        Text(
            text = "Hello Team 02", modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(12.dp)
        )
        Text(text = "Hello Team 02", modifier = Modifier.align(Alignment.TopEnd))
        Text(text = "Hello Team 02", modifier = Modifier.align(Alignment.CenterEnd))
        Text(text = "Hello Team 02", modifier = Modifier.align(Alignment.CenterStart))
        Box(
            modifier = Modifier
                .padding(12.dp)
                .size(200.dp)
                .background(Color.Cyan)
                .align(Alignment.BottomStart)
        ) {
            Text(text = "Internal Box", modifier = Modifier.align(Alignment.TopStart))
            Text(text = "Internal Box", modifier = Modifier.align(Alignment.CenterStart))
            Text(text = "Internal Box", modifier = Modifier.align(Alignment.BottomStart))
        }
    }

}