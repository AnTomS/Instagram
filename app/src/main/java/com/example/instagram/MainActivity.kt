package com.example.instagram

import android.os.Bundle


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
        val navView: BottomNavigationView = findViewById(R.id.bottomNav)

        //получаем доступ к фрагменту, в который будем вставлять другие фрагменты, через supportFragmentManager
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        //получаем доступ к Навконтроллеру. Навконтроллер, в свою очередь, связан с Навигацией
        val navController: NavController = navHostFragment.navController

        navView.setupWithNavController(navController)
    }
}




