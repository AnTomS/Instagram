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


class RegisterFragmentMail : Fragment() {
    private val args by navArgs<RegisterFragmentNamePassArgs>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentRegisterMailBinding.inflate(inflater, container, false)
        binding.nextBtn.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragmentMail_to_registerFragmentNamePass)

            val email = binding.newEmailInput.text.toString()
        }


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


}