package com.example.instagram.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.instagram.R
import com.example.instagram.databinding.FragmentRegisterNamepassBinding
import com.example.instagram.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterFragmentNamePass : Fragment() {


    private val args by navArgs<RegisterFragmentNamePassArgs>()
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var _DataBase: DatabaseReference
    private lateinit var register_Btn: Button
    private lateinit var fullNameInput: EditText
    private lateinit var passwordInput: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentRegisterNamepassBinding.inflate(inflater, container, false)

        register_Btn = binding.registerBtn
        fullNameInput = binding.newFullNameInput
        passwordInput = binding.addPassword
        coordinateBtnWithInputs(register_Btn, fullNameInput, passwordInput)

        binding.registerBtn.setOnClickListener {

            val fullName = binding.newFullNameInput.text.toString()
            val password = binding.addPassword.text.toString()
            val email = args.email
            onRegister(fullName, password, email)


        }

        return binding.root
    }


    private fun onRegister(fullName: String, password: String, email: String?) {
        firebaseAuth = FirebaseAuth.getInstance()
        _DataBase = FirebaseDatabase.getInstance().getReference("users")
        if (fullName.isNotEmpty() && password.isNotEmpty()) {
            if (email != null) {
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            val user = makeUser(fullName, email)
                            _DataBase.child("users").child(it.result.user!!.uid).setValue(user)
                                .addOnCompleteListener {
                                    if (it.isSuccessful) {
                                        findNavController().navigate(R.id.action_registerFragmentMail_to_homeFragment)
                                    } else {
                                        Log.e("Tag", "failed to create user profile", it.exception)
                                        Toast.makeText(
                                            requireActivity(),
                                            "Something went wrong. Try again later",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                        } else {
                            Log.e("Tag", "onRegister: Email is null")
                            Toast.makeText(
                                requireActivity(),
                                "Please enter email",
                                Toast.LENGTH_SHORT
                            ).show()
                            findNavController().popBackStack()
                        }
                    }
            } else {
                Toast.makeText(
                    requireActivity(),
                    "Please enter Full Name and Password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun username(fullName: String): String {
        return fullName.lowercase().replace(" ", ".")
    }

    private fun makeUser(fullName: String, email: String): User {
        val username = username(fullName)
        return User(name = fullName, username = username, email = email)
    }


}

