package dev.mina.internship

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import dev.mina.internship.room.MyDatabase
import dev.mina.internship.room.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    val database = Room.databaseBuilder(
        AppContext.appContext,
        MyDatabase::class.java,
        "MyDatabase"
    ).build()
    val userDao = database.userDao()

    var shouldTrigger: Boolean = false


    val dataFlow: Flow<String> = flow {
        emit("")
    }

    private val _users: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())
    val users: StateFlow<List<User>> = _users.asStateFlow()

    init {
        viewModelScope.launch {

            apiConnectionCall()
        }
    }

    fun retrieveData() {
        // call api and get some string
        viewModelScope.launch {
            // new thread to get string from API1
            val result = async {
                // api call / Room database connection
                "End Result"
            }
            //  according to first result of API1 another API call will be done
            val stringResult = result.await()
            if (stringResult.isNotEmpty()) {
                databaseConnection()
            } else {
                apiConnection()
            }
        }
    }


    suspend fun apiConnection() {
        val job = viewModelScope.launch {
            //
            //
            //
            //

        }
        job.join()

    }

    suspend fun apiConnectionCall() {
        //
        //
        //
        //
    }

    suspend fun databaseConnection() {
        val result = viewModelScope.async {
            // api call / Room database connection
            // 5 seconds operation
            "End Result"
        }

        //  according to first result of API1 another API call will be done
        val stringResult = result.await()
    }

    fun retrieveUserList() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = userDao.getALlUsers()
            _users.value = list
        }
    }

    fun saveData(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.addUser(user)
        }
    }

    fun deleteUserAndRefresh(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.deleteUser(user)
            retrieveUserList()
        }
    }
    fun deleteAllUsersAndRefresh(users: List<User>) {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.deleteUsers(users)
            retrieveUserList()
        }
    }
}