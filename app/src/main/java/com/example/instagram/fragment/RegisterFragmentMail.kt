package com.example.instagram.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.instagram.R
import com.example.instagram.databinding.FragmentRegisterMailBinding
import com.example.instagram.databinding.FragmentRegisterNamepassBinding


class RegisterFragmentMail : Fragment() {

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
            val email = binding.newEmailInput.text.toString()
            if (email.isNotEmpty()) {
                findNavController().navigate(R.id.action_registerFragmentMail_to_registerFragmentNamePass)
            } else {
                Toast.makeText(requireActivity(), "Введите Ваш адрес электронной почты", Toast.LENGTH_SHORT).show()
            }
            }



        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


}