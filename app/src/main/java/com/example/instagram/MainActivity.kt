package com.example.instagram

import android.os.Bundle


import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.instagram.databinding.ActivityMainBinding
import com.example.instagram.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        loadFragment(HomeFragment.newInstance())


        binding.bottomNav.setOnItemSelectedListener { item ->
            val fragment: Fragment
            when (item.itemId) {
                R.id.homeFragment -> {
                    fragment = HomeFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.searchFragment -> {
                    fragment = SearchFragment()
                    loadFragment(fragment)
                    true

                }
                R.id.shareFragment -> {
                    fragment = ShareFragment()
                    loadFragment(fragment)
                    true

                }
                R.id.likedFragment -> {
                    fragment = LikedFragment()
                    loadFragment(fragment)
                    true

                }
                R.id.profileFragment -> {
                    fragment = ProfileFragment()
                    loadFragment(fragment)
                    true

                }
                else -> false
            }

        }


    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}

