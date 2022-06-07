package com.hsdesigns.caramelwallet.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hsdesigns.caramelwallet.R
import com.hsdesigns.caramelwallet.databinding.FragmentFundWalletBinding
import com.hsdesigns.caramelwallet.utils.*

//import com.hsdesigns.caramelwallet.utils.showBottomNavigation


class FundWalletFragment : Fragment() {
    private var _binding: FragmentFundWalletBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFundWalletBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clearFocus()
        handleBackPress()
        handleOnClickListeners()
//        showBottomNavigation()
//        hideBottomNavigation()
    }
    private fun clearFocus() {
        with(binding){
            fragmentFundWalletLl.setOnClickListener {
                fragmentEnterAmountEdt.clearFocus()
            }
        }
    }
    private fun handleOnClickListeners(){
        with(binding){
            fragmentFundWalletBackArrowIv.setOnClickListener {  findNavController().popBackStack() }
            fragmentFundWalletBtn.setOnClickListener {
                findNavController().navigate(FundWalletFragmentDirections.actionFundWalletFragmentToDashboardFragment())
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}