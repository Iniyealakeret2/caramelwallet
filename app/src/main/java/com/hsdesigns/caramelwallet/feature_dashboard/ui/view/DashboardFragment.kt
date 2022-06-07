package com.hsdesigns.caramelwallet.feature_dashboard.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hsdesigns.caramelwallet.R
import com.hsdesigns.caramelwallet.databinding.FragmentDashboardBinding
import com.hsdesigns.caramelwallet.common.utils.*

//import com.hsdesigns.caramelwallet.common.utils.showBottomNavigation


class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleBackPress()
        handleOnClickListeners()
//        showBottomNavigation()
//        hideBottomNavigation()
        binding.fragmentDashboardBackArrowIv.setOnClickListener {
            findNavController().popBackStack(R.id.loginFragment,false)
        }
    }
    private fun handleOnClickListeners(){
        with(binding){
            fragmentDashboardCardOne.setOnClickListener {
                findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToFundWalletFragment(), customNavAnimation().build())
            }
           fragmentDashboardCardTwo.setOnClickListener {
               findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToWithdrawFundFragment(), customNavAnimation().build())
           }
            fragmentDashboardCardThree.setOnClickListener {
                findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToAddItemFragment(), customNavAnimation().build())
            }
           fragmentDashboardCardFour.setOnClickListener {
               findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToItemsListFragment(), customNavAnimation().build())
           }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}