package dev.mina.internship

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mina.internship.retrofit.Retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    fun retrieveDataWithRetrofit() {
        viewModelScope.launch(Dispatchers.IO) {

            val contactsAPI = Retrofit.retrieveContactService()
            val contacts = contactsAPI.getContacts()
            Log.d("Network", contacts.contacts.toString())

        }
    }

}