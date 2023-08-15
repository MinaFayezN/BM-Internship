package dev.mina.internship

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private var list = mutableListOf("Name 01", "Name 02", "Name 03", "Name 04")


    private val listMLD: MutableLiveData<List<String>?> = MutableLiveData(null)
    val listLiveData: LiveData<List<String>?> = listMLD

    private val listFlow: MutableStateFlow<List<String>?> = MutableStateFlow(null)
    val listStateFlow = listFlow.asStateFlow()


    fun updateDatabase(name: String, email: String) {
        //
        if (name.isNotBlank() && email.isNotBlank()) {
            list.add(name)
            listFlow.value = list.toMutableList()
            listMLD.value = list.toMutableList()
        }
    }
}

