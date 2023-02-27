package com.example.instagram.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.instagram.databinding.FragmentEditProfileBinding
import com.example.instagram.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class EditProfileFragment : Fragment() {

    private lateinit var button: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment

        val binding = FragmentEditProfileBinding.inflate(inflater, container, false)

        binding.closeImage.setOnClickListener {
            findNavController().navigateUp()
        }

        val auth = FirebaseAuth.getInstance()
        val database = FirebaseDatabase.getInstance().reference
        database.child("users").child(auth.currentUser!!.uid)
            .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                val user = it.getValue(User::class.java)
                binding.apply {
                    editName.setText(user?.name ?: "")
                    editUsername.setText(user?.username ?: "")
                    editEmail.setText(user?.email ?: "")
                    bio.setText(user?.bio ?: "")
                    editPhoneNumber.setText(user?.phone?.toString() ?: "")
                    addWebsite.setText(user?.website ?: "")
                }
            })


        return binding.root
    }


}


