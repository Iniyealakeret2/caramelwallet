package com.hsdesigns.caramelwallet.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hsdesigns.caramelwallet.R
import com.hsdesigns.caramelwallet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setUpBottomNavigation()
    }

//        private fun setUpBottomNavigation(){
//        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//        val bottomNavigationView: BottomNavigationView = binding.bottomNavigationView
//        bottomNavigationView.setupWithNavController(navHostFragment.navController)
//    }
}