package dev.mina.internship

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {

    fun updateFromSelected(selected: String) {
        // update from value
        fromCurrencySelectedItem.value = selected
        // update to list accordingly

    }


    val originalCurrencyList: MutableStateFlow<List<String>> = MutableStateFlow(listOf())
    val fromCurrencyList: MutableStateFlow<List<String>> = MutableStateFlow(listOf("item 01","item 02","item 03","item 04"))
    val fromCurrencySelectedItem: MutableStateFlow<String> = MutableStateFlow("item 01")



    init {
        // retrieve List from API
        // emit value to originalList
    }
}