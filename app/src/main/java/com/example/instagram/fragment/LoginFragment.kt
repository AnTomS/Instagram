package com.example.instagram.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.instagram.R
import com.example.instagram.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment(), TextWatcher, View.OnClickListener {

    private lateinit var login_btn: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentLoginBinding.inflate(inflater, container, false)



        login_btn = binding.loginBtn
        emailInput = binding.emailInput
        passwordInput = binding.passwordInput

        binding.emailInput.addTextChangedListener(this)
        binding.passwordInput.addTextChangedListener(this)
        login_btn.isEnabled = false
        login_btn.setOnClickListener(this)
        mAuth=FirebaseAuth.getInstance()
        return binding.root

    }

    override fun onClick(v: View) {
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()
        if (validate(email, password)) {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    findNavController().navigate(R.id.homeFragment)
                }
            }
        } else {
            Toast.makeText(requireActivity(), "Please enter email and password", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        login_btn.isEnabled =
            validate(emailInput.text.toString(), passwordInput.text.toString())
    }


    private fun validate(email: String, password: String) =
        email.isNotEmpty() && password.isNotEmpty()
}

