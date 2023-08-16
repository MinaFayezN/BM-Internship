package dev.mina.internship

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.mina.internship.ui.theme.BMInternshipTheme

class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    lateinit var textView: TextView

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val async = MyAsyncTask()
//            async.execute("", "", "")
            BMInternshipTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    var text by remember { mutableStateOf("") }
                    TextField(value = text, onValueChange = { text = it })
                    Button(onClick = {
                        Log.d("Thread", "${Thread.currentThread()}")
                        viewModel.retrieveData()
                    }) {
                        Text(text = "Process Data")
                    }
                }
            }
        }
    }


    inner class MyAsyncTask : AsyncTask<String, String, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            // run on UI thread before background functionality
            // ex: show loading
            textView.setText("Loading")
        }

        override fun doInBackground(vararg p0: String?): String {
            // done in background thread
            repeat(5000) {
                Log.d("Thread", "$it ${Thread.currentThread()}")

                if (it == 1000) {
                    // do something in ui thread
                    publishProgress("")
                }
            }
            return ""
        }

        override fun onProgressUpdate(vararg values: String?) {
            super.onProgressUpdate(*values)
            // run on main thread
            textView.setText("In Progress")

        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            // run on UI thread after background functionality
            textView.setText("Done Loading $result")
        }

    }
}
