package com.hsdesigns.caramelwallet.feature_authentication.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hsdesigns.caramelwallet.databinding.FragmentLoginBinding
import com.hsdesigns.caramelwallet.common.utils.*


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clearFocus()
        handleOnClickListeners()
        handleBackPress()
//        hideBottomNavigation()
        binding.fragmentUserLoginBackArrowIv.setOnClickListener {  handlePopBackStack() }
    }
    private fun clearFocus() {
        with(binding){
            fragmentLoginLl.setOnClickListener {
                fragmentLoginEmailEdt.clearFocus()
            }
        }
    }
    private fun handleOnClickListeners(){
        with(binding){
            fragmentLoginLoginBtn.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToDashboardFragment(),customNavAnimation().build())
            }
            fragmentLoginNoAccountTv.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegistrationFragment(), customNavAnimation().build())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}