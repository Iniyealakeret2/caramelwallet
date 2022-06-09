package com.hsdesigns.caramelwallet.feature_dashboard.ui.view

import android.content.Context
import android.os.Bundle
import android.text.BoringLayout.make
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.hsdesigns.caramelwallet.databinding.FragmentItemsListBinding
import com.hsdesigns.caramelwallet.feature_dashboard.data.remote.dto.ProductsDto
import com.hsdesigns.caramelwallet.feature_dashboard.ui.view.adapter.ListItemAdapter
import com.hsdesigns.caramelwallet.common.utils.*
import com.hsdesigns.caramelwallet.feature_dashboard.domain.model.Products
import com.hsdesigns.caramelwallet.feature_dashboard.ui.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

//import com.hsdesigns.caramelwallet.common.utils.showBottomNavigation

@AndroidEntryPoint
class ItemsListFragment : Fragment() {
    private var _binding: FragmentItemsListBinding? = null
    private val binding get() = _binding!!
    private val dashboardViewModel: DashboardViewModel by viewModels()

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
        setUpObserver()
        dashboardViewModel.getAllProducts()
//        dashboardViewModel.getAllProducts()
       // initRecyclerview(listItemData)
//        showBottomNavigation()
//        hideBottomNavigation()
    }
    private fun initRecyclerview(listOfItems: List<Products>) {
        val listItemRecyclerviewAdapter = ListItemAdapter(listOfItems,requireContext())
        val recyclerview = binding.fragmentItemsListRV
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        recyclerview.adapter = listItemRecyclerviewAdapter
    }
    private fun handleOnClickListeners(){
        binding.fragmentItemListBackArrowIv.setOnClickListener {  findNavController().popBackStack() }
    }

    private fun setUpObserver() {
        dashboardViewModel.state.observe(viewLifecycleOwner){ product ->
            when (product){
                is Resource.Loading ->{
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success ->{
                    binding.progressBar.visibility = View.GONE
                    initRecyclerview(product.data!!)
                }
                is Resource.Error ->{
                    binding.progressBar.visibility = View.GONE
                    view?.let { Snackbar.make(requireContext(), it,"${product.message}", Snackbar.LENGTH_LONG).show() }
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}