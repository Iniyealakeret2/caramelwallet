package com.hsdesigns.caramelwallet.feature_dashboard.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hsdesigns.caramelwallet.databinding.FragmentItemsListBinding
import com.hsdesigns.caramelwallet.feature_dashboard.data.remote.dto.ProductsDto
import com.hsdesigns.caramelwallet.feature_dashboard.ui.view.adapter.ListItemAdapter
import com.hsdesigns.caramelwallet.common.utils.*

//import com.hsdesigns.caramelwallet.common.utils.showBottomNavigation


class ItemsListFragment : Fragment() {
    private var _binding: FragmentItemsListBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentItemsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleBackPress()
        handleOnClickListeners()
        initRecyclerview(listItemData)
//        showBottomNavigation()
//        hideBottomNavigation()
    }
    private fun initRecyclerview(listOfItems: List<ProductsDto>) {
        val listItemRecyclerviewAdapter = ListItemAdapter(listOfItems,requireContext())
        val recyclerview = binding.fragmentItemsListRV
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        recyclerview.adapter = listItemRecyclerviewAdapter
    }
    private fun handleOnClickListeners(){
        binding.fragmentItemListBackArrowIv.setOnClickListener {  findNavController().popBackStack() }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}