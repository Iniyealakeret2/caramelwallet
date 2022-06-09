package com.hsdesigns.caramelwallet.feature_authentication.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hsdesigns.caramelwallet.databinding.FragmentRegistrationBinding
import com.hsdesigns.caramelwallet.common.utils.*

class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clearFocus()
        handleOnClickListeners()
        handleBackPress()
//        hideBottomNavigation()
    }
    private fun clearFocus() {
        with(binding){
            fragmentRegistrationLl.setOnClickListener {
                fragmentRegisterEmailEdt.clearFocus()
            }
        }
    }
    private fun handleOnClickListeners(){
        with(binding){
            fragmentUserAccountBackArrowIv.setOnClickListener { handlePopBackStack() }
            fragmentRegisterBtn.setOnClickListener {
                findNavController().navigate(RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment(), customNavAnimation().build())
            }
            fragmentHaveAccountTv.setOnClickListener {
                findNavController().navigate(RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment(), customNavAnimation().build())
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}