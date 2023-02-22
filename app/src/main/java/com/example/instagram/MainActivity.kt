package com.example.instagram

import android.os.Bundle
import android.view.View


import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.instagram.databinding.ActivityMainBinding
import com.example.instagram.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //получаем доступ к BottomNavigationView
        val bottomNavigation = binding.bottomNav

        //получаем доступ к фрагменту, в который будем вставлять другие фрагменты, через supportFragmentManager
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // ограничиваем видимость BottomNavigationView, чтобы было активно только на главные фрагменты
        val navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment, R.id.likedFragment, R.id.profileFragment, R.id.searchFragment, R.id.shareFragment -> bottomNavigation.visibility =
                    View.VISIBLE
                else -> bottomNavigation.visibility = View.GONE
            }
        }
        //получаем доступ к Навконтроллеру. Навконтроллер, в свою очередь, связан с Навигацией
        bottomNavigation.setupWithNavController(navController)

    }
}




