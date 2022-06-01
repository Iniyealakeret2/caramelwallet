package com.hsdesigns.caramelwallet.utils

import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hsdesigns.caramelwallet.R

fun Fragment.hideBottomNavigation(){
    val navBar = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
    navBar.visibility = View.GONE
}
// this is used for navigation animation
fun Fragment.customNavAnimation(): NavOptions.Builder {
    val navBuilder: NavOptions.Builder = NavOptions.Builder()
    navBuilder.setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right)
    return navBuilder
}
fun Fragment.popBackStack(){
    findNavController().popBackStack()
}

fun Fragment.handleBackPress(){
    activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            popBackStack()
        }
    })
}