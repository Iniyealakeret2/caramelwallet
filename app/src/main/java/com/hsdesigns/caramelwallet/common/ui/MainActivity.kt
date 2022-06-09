package com.hsdesigns.caramelwallet.common.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hsdesigns.caramelwallet.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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