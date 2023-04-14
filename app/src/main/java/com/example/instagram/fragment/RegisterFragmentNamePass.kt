package com.example.instagram.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.instagram.R
import com.example.instagram.databinding.FragmentRegisterMailBinding
import com.example.instagram.databinding.FragmentRegisterNamepassBinding

class RegisterFragmentNamePass : Fragment() {
    private val args by navArgs<RegisterFragmentNamePassArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentRegisterNamepassBinding.inflate(inflater, container, false)
        binding.registerBtn.setOnClickListener {
            findNavController()

            val email = args.
            val name = binding.newFullNameInput.text.toString()
            val password = binding.addPassword.text.toString()
        }


        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


}