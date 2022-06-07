package com.hsdesigns.caramelwallet.feature_dashboard.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.hsdesigns.caramelwallet.databinding.FragmentAddItemBinding
import com.hsdesigns.caramelwallet.common.utils.*


class AddItemFragment : Fragment() {
    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!
    private lateinit var onBackPressedCallback: OnBackPressedCallback
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clearFocus()
        handleBackPress()
        handleOnClickListeners()
        binding.fragmentAddItemBackArrowIv.setOnClickListener {  findNavController().popBackStack() }
//        showBottomNavigation()
//        hideBottomNavigation()
    }
    private fun clearFocus() {
        with(binding){
            fragmentListItemLl.setOnClickListener {
               fragmentEnterProductIdEdt.clearFocus()
            }
        }

    }
    private fun handleOnClickListeners(){
        with(binding){
            fragmentAddItemBtn.setOnClickListener{
                findNavController().navigate(AddItemFragmentDirections.actionAddItemFragmentToItemsListFragment(), customNavAnimation().build())
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        onBackPressedCallback.isEnabled = false
        onBackPressedCallback.remove()
    }
}