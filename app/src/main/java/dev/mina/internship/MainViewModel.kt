package dev.mina.internship

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

     var list = mutableListOf("Name 01", "Name 02", "Name 03", "Name 04")

    fun retrieveUsers(): List<String> {
        // connect to db / API
        return list
    }

    fun updateDatabase(name: String, email: String): Boolean {
        //
        return (name.isNotBlank() && email.isNotBlank()).also {
            if (it) list.add(name)
        }
    }


}