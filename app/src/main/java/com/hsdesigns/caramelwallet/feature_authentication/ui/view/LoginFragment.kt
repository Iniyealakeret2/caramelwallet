package com.hsdesigns.caramelwallet.feature_authentication.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.hsdesigns.caramelwallet.databinding.FragmentLoginBinding
import com.hsdesigns.caramelwallet.common.utils.*
import com.hsdesigns.caramelwallet.feature_authentication.domain.model.LoginRequest
import com.hsdesigns.caramelwallet.feature_authentication.ui.viewmodel.AuthenticationViewmodel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val authenticationViewmodel: AuthenticationViewmodel by viewModels()

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
        loginObserver()
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
                val email = fragmentLoginEmailEdt.text.toString()
                val password = fragmentLoginPasswordEdt.text.toString()
                authenticationViewmodel.userLogin(LoginRequest(email = email, password = password))
//                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToDashboardFragment(),customNavAnimation().build())
            }
            fragmentLoginNoAccountTv.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegistrationFragment(), customNavAnimation().build())
            }
        }
    }
    private fun loginObserver() {
        authenticationViewmodel.loginState.observe(viewLifecycleOwner){ response ->
            when (response){
                is Resource.Loading ->{
                    binding.loginProgressBar.visibility = View.VISIBLE
                }
                is Resource.Success ->{
                    binding.loginProgressBar.visibility = View.GONE
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToDashboardFragment(),customNavAnimation().build())
                    Toast.makeText(requireContext(), "Login Successfully", Toast.LENGTH_LONG).show()
                }
                is Resource.Error ->{
                    binding.loginProgressBar.visibility = View.GONE
                    view?.let { Snackbar.make(requireContext(), it,"${response.message}", Snackbar.LENGTH_LONG).show() }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}