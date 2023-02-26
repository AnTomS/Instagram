package com.example.instagram.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.StateSet.TAG
import androidx.navigation.fragment.findNavController

import com.example.instagram.databinding.FragmentEditProfileBinding
import com.example.instagram.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


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
        val user = auth.currentUser
        val database = FirebaseDatabase.getInstance().reference
        database.child("users").child(user!!.uid)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(data: DataSnapshot) {
                    val user = data.getValue(User::class.java)
                    binding.editName.setText(user!!.name, TextView.BufferType.EDITABLE)
                    binding.editUsername.setText(user.username, TextView.BufferType.EDITABLE)
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e(TAG, "onCanceled", error.toException())
                }

            })



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
