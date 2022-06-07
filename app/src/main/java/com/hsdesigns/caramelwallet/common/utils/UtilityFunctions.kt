package com.hsdesigns.caramelwallet.common.utils

import android.view.KeyEvent
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.hsdesigns.caramelwallet.R

//fun Fragment.hideBottomNavigation(){
//    val navBar = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//    navBar.visibility = View.GONE
//}
//fun Fragment.showBottomNavigation(){
//    val navBar = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//    navBar.visibility = View.VISIBLE
//}
// this is used for navigation animation
fun Fragment.customNavAnimation(): NavOptions.Builder {
    val navBuilder: NavOptions.Builder = NavOptions.Builder()
    navBuilder.setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right)
    return navBuilder
}
fun Fragment.handlePopBackStack(){
    findNavController().popBackStack(R.id.welcomeFragment,false)
}

fun Fragment.handleBackPress(){
    activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            isEnabled = false
            activity?.onBackPressed()
        }
    })
}
fun Fragment.destinationChange(): NavController {
    val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
    return navHostFragment.navController
}

fun backButtonHandler(fragment: Fragment){
    fragment.view?.isFocusableInTouchMode = true
    fragment.view?.requestFocus()
    fragment.view?.setOnKeyListener { _, keyCode, _ ->
        keyCode == KeyEvent.KEYCODE_BACK
    }
}
