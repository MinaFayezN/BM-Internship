package dev.mina.internship

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    fun retrieveData() {

        val vmsJob = viewModelScope.launch(Dispatchers.IO) {
            //


            val job = launch {
                // background thread
                Log.d("Thread 2", "${Thread.currentThread()}")
                repeat(5000) {
                    Log.d("Thread 2", "$it")
                }
            }

            Log.d("Thread 1", "${Thread.currentThread()}")
            repeat(5000) {

                if (it == 2000) {
                    Log.d("Thread 1", "Joining the other job")
                    if (job.isActive)
                        job.join()
                }
                Log.d("Thread 1", "$it")
            }
        }

//
        //
        //

    }

    override fun onCleared() {
        super.onCleared()

    }

    private fun threadDemo() {
        val thread = Thread {
            // run code
            repeat(5000) {
                Log.d("Thread", "$it ${Thread.currentThread()}")
            }


        }
        thread.start()
        MyThread().start()
        DownloadThread().start()
    }
}


class MyThread : Thread() {
    override fun run() {
        super.run()
        repeat(5000) {
            Log.d("Thread", "$it ${currentThread()}")
        }
    }
}

class DownloadThread : Thread() {
    override fun run() {
        super.run()
        // Download Data from API

        repeat(5000) {
            Log.d("Thread", "$it ${currentThread()}")
        }
    }
}
