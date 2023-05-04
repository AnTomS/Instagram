package com.example.instagram.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.instagram.databinding.FragmentRegisterMailBinding
import com.google.firebase.auth.FirebaseAuth


class RegisterFragmentMail : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var next_Btn: Button
    private lateinit var emailInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentRegisterMailBinding.inflate(inflater, container, false)
        firebaseAuth = FirebaseAuth.getInstance()


        next_Btn = binding.nextBtn
        emailInput = binding.newEmailInput
        coordinateBtnWithInputs(next_Btn, emailInput)

        binding.nextBtn.setOnClickListener {
            val email = binding.newEmailInput.text.toString()
            if (email.isNotEmpty()) {
                firebaseAuth.fetchSignInMethodsForEmail(email).addOnCompleteListener {
                    if (it.isSuccessful) {
                        if (it.result.signInMethods!!.isEmpty() != false) {
                            val action =
                                RegisterFragmentMailDirections.actionRegisterFragmentMailToRegisterFragmentNamePass(
                                    email
                                )
                            findNavController().navigate(action)
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "Пользователь с таким email уже существует",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            requireContext(), "it.exception",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }

            } else {
                Toast.makeText(
                    requireContext(),
                    "Введите Ваш адрес электронной почты",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


}