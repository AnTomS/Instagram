package com.example.instagram

import android.R
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.instagram.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

//    private val mOnNavigationItemSelectedListener =
//        BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            when (item.) {
//                R.id.home -> {
//                    loadFragment(HomeFragment.newInstance())
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.search -> {
//                    loadFragment(DashboardFragment.newInstance())
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_notifications -> {
//                    loadFragment(NotificationsFragment.newInstance())
//                    return@OnNavigationItemSelectedListener true
//                }
//            }
//            false
//        }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topToolbar)

    }
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
}

//
//
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

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
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