package dev.mina.internship.presentation.list

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun ListScreen(
    listViewModel: ListViewModel = viewModel(),
    flow: MutableStateFlow<String>,
    onButtonCLicked: () -> Unit,
) {
}