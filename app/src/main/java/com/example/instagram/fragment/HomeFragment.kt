package com.example.instagram.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.instagram.R
import com.google.android.material.bottomnavigation.BottomNavigationView



class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_home, container, false)

    companion object {
        fun newInstance() = LikedFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }}



//        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNav)
//
//
//        val navController =
//            (childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
//
//        if (navController != null) {
//            bottomNavigationView.setupWithNavController(navController)
//        } else {
//            throw RuntimeException("Controller not found")



////        bottomNavigationView.setupWithNavController(navController)
//        }
//    }
//}