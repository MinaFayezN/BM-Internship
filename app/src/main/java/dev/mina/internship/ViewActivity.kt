package dev.mina.internship

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity

class ViewActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        Log.d("LifeCycle", "onCreate called Activity 02")
    }


    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "onStart called Activity 02")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "onResume called Activity 02")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "onPause called Activity 02")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "onStop called Activity 02")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycle", "onRestart called Activity 02")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "onDestroy called Activity 02")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("LifeCycle", "onSaveInstanceState called Activity 02")
        outState.putString("Name","My Name"/* get string from user input field */)
    }
}