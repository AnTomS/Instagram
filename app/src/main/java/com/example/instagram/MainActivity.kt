package com.example.instagram

import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.instagram.databinding.ActivityMainBinding
import com.example.instagram.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding
    private lateinit var bottomNav: BottomNavigationView


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.bottomNav.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.ic_home ->
//                    Toast.makeText(this, "home", Toast.LENGTH_SHORT).show()
//                R.id.ic_likes
//                -> Toast.makeText(this, "likes", Toast.LENGTH_SHORT).show()
//                R.id.ic_search
//                -> Toast.makeText(this, "search", Toast.LENGTH_SHORT).show()
//                R.id.ic_share
//                -> Toast.makeText(this, "shares", Toast.LENGTH_SHORT).show()
//                R.id.ic_profile
//                -> Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show()
//
//            }
//            true
//        }
//
//    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val toolbar = supportActionBar;

        loadFragment(HomeFragment.newInstance())


        binding.bottomNav.setOnItemSelectedListener { item ->
            val fragment: Fragment
            when (item.itemId) {
                R.id.ic_home-> {
                    toolbar?.setTitle("Home")
                    fragment = HomeFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.ic_search -> {
                    toolbar?.setTitle("Search")
                    fragment = SearchFragment()
                    loadFragment(fragment)
                    true

                }
                R.id.ic_share -> {
                    toolbar?.setTitle("Share")
                    fragment = ShareFragment()
                    loadFragment(fragment)
                    true

                }
                R.id.ic_likes -> {
                    toolbar?.setTitle("My Liked")
                    fragment = LikedFragment()
                    loadFragment(fragment)
                    true

                }
                R.id.ic_profile -> {
                    toolbar?.setTitle("Library")
                    fragment = ProfileFragment()
                    loadFragment(fragment)
                    true

                }
                else -> false
            }

        }

        binding.bottomNav.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    Toast.makeText(this, "Home Item reselected", Toast.LENGTH_SHORT).show()
                }
                R.id.searchFragment -> {
                    Toast.makeText(this, "Search Item reselected", Toast.LENGTH_SHORT).show()
                }
                R.id.shareFragment-> {
                    Toast.makeText(this, "Share Item reselected", Toast.LENGTH_SHORT).show()
                }
                R.id.likedFragment -> {
                    Toast.makeText(this, "My liked Item reselected", Toast.LENGTH_SHORT).show()
                }
                R.id.profileFragment -> {
                    Toast.makeText(this, "My profile Item reselected", Toast.LENGTH_SHORT).show()

                }
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


//        val navView: BottomNavigationView = findViewById(R.id.bottomNav)
//        val navController = findNavController(R.id.container)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.activity_main_to_home_fragment,
//            R.id.activity_main_to_search_fragment,
//            R.id.activity_main_to_share_fragment,
//            R.id.activity_main_to_liked_fragment,
//            R.id.activity_main_to_profile_fragment))
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
//    }
//}

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu., menu)
//        return true
//    }


//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAnchorView(R.id.fab)
//                .setAction("Action", null).show()
//        }
//    }
//
//
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//       // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
//}