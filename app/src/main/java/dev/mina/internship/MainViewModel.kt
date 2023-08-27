package dev.mina.internship

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainViewModel : ViewModel() {

    init {
//        retrieveDataWithRetrofit()
    }

    private val mutableContactsFlow = MutableStateFlow<Contacts?>(null)
    val contactsFlow: StateFlow<Contacts?> = mutableContactsFlow


    fun retrieveDataWithRetrofit() {
        viewModelScope.launch(Dispatchers.IO) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://mocki.io/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


            val contactsAPI = retrofit.create(ContactsAPI::class.java)
            val contacts = contactsAPI.getContacts()

          val response =  contactsAPI.getConversionForList("usd", contacts.contacts.joinToString(",") { it.name })
            //

            response.contacts.map{

            }
            mutableContactsFlow.value = contacts

            Log.d("Network", contacts.contacts.toString())

        }
    }

    fun retrieveContactDetailsWithRetrofit(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://mocki.io/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


            val contactsAPI = retrofit.create(ContactsAPI::class.java)
            val contact = contactsAPI.getContactDetails(id)

        }
    }


    fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                val url =
                    URL("https://mocki.io/v1/9a54a7b3-497b-41f3-b13f-23964afd4bd6")/* url from backend exposes data in */
                val connection =
                    url.openConnection() as HttpsURLConnection /* connection type http/https */
                connection.requestMethod = "GET" /* get/post/put */
                val responseStream = connection.inputStream
                val reader =
                    BufferedReader(InputStreamReader(responseStream)) /* Reader to read data line by line */
                val responseStringBuilder = StringBuilder() /* to append lines in */
                var lineString: String? = "" /* to save each line */
                while (reader.readLine()
                        .also { lineString = it } != null
                ) { /* loop to read line by line and check if not null -> save it in line string then append linestring into the string builder*/
                    responseStringBuilder.append(lineString)
                }
                val response =
                    responseStringBuilder.toString() /* get the full string from string builder */


                val jsonResponse = JSONObject(response) /* convert response data to JSON */
                val contactsArray =
                    jsonResponse.getJSONArray("contacts") /* get the contacts array from json*/
                val contactList =
                    mutableListOf<Contact>() /* create empty list to save contact data one by one*/
                for (i in 0 until contactsArray.length()) { /* loop into contacts array to parse contact data */
                    val contact = contactsArray.getJSONObject(i)
                    val id = contact.getString("id")
                    val name = contact.getString("name")
                    val age = contact.getInt("age")
                    val email = contact.getString("email")
                    contactList.add(
                        Contact(
                            contactID = id, name = name, age = age, email = email,
                            gender = "",
                            companyName = "",
                            photo = "",
                        )
                    )
                }
                /* no we have a list of contacts -> LiveData/Flow  */
                Log.d("Network", response)
                /* closing all opened connections and streams*/
                reader.close()
                responseStream.close()
                connection.disconnect()
            }.onFailure {
                Log.d("Network", it.message ?: it.toString())
            }
        }
    }
}

