package dev.mina.internship

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogWindowProvider

@Composable
fun FullScreenDialog(
    onDismiss: () -> Unit,
    content: @Composable () -> Unit,
) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Green,
            shadowElevation = 8.dp
        ) {
            (LocalView.current.parent as DialogWindowProvider)?.window?.setDimAmount(1F)
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // Add your dialog content here
                content()
            }
        }
    }
}