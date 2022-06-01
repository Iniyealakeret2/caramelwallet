package com.hsdesigns.caramelwallet.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hsdesigns.caramelwallet.R
import com.hsdesigns.caramelwallet.databinding.FragmentWelcomeBinding
import com.hsdesigns.caramelwallet.utils.customNavAnimation
import com.hsdesigns.caramelwallet.utils.hideBottomNavigation

class WelcomeFragment : Fragment() {
    private  var _binding : FragmentWelcomeBinding? = null
    private val binding get()  =_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideBottomNavigation()
        activateClickListener()
    }
    private fun activateClickListener() {
        binding.fragmentWelcomeLoginBtn.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment(), customNavAnimation().build())
        }
        binding.fragmentWelcomeRegisterBtn.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToRegistrationFragment(), customNavAnimation().build())
        }
    }
}