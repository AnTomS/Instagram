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
import com.example.instagram.databinding.FragmentLoginBinding


class LoginFragment : Fragment(), TextWatcher {

    private lateinit var login_btn: Button
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
        return binding.root

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        login_btn.isEnabled =
            emailInput.text.toString().isNotEmpty() && passwordInput.text.toString().isNotEmpty()
    }


}

