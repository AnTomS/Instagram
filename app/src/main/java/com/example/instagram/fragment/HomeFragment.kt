package com.example.instagram.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.StateSet.TAG
import com.example.instagram.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth


class HomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = inflater.inflate(R.layout.fragment_home, container, false)


        val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword("thekeibee@gmail.com", "password")
            .addOnCompleteListener {task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Successfully signed in with email link!")
                    val result = task.result
                }else {
                    Log.e(TAG, "Error signing in with email link", task.exception)
                }
            }

        return binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
