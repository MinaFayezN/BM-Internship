package dev.mina.internship

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MyFragment : Fragment(R.layout.fragment_new) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("LifeCycle", "onCreate called Fragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        Log.d("LifeCycle", "onCreateView called Fragment")
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("LifeCycle", "onViewCreated called Fragment")
    }

    override fun onStart() {
        super.onStart()

        Log.d("LifeCycle", "onStart called Fragment")
    }

    override fun onResume() {
        super.onResume()

        Log.d("LifeCycle", "onResume called Fragment")
    }

    override fun onPause() {
        super.onPause()

        Log.d("LifeCycle", "onPause called Fragment")
    }

    override fun onStop() {
        super.onStop()

        Log.d("LifeCycle", "onStop called Fragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.d("LifeCycle", "onDestroyView called Fragment")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("LifeCycle", "onDestroy called Fragment")
    }


}