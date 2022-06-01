package com.hsdesigns.caramelwallet.ui.view

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hsdesigns.caramelwallet.R
import com.hsdesigns.caramelwallet.databinding.FragmentItemsListBinding
import com.hsdesigns.caramelwallet.ui.model.ListOfItemsDto
import com.hsdesigns.caramelwallet.ui.view.adapter.ListItemRecyclerViewAdapter
import com.hsdesigns.caramelwallet.utils.BuyItemClickListenerInterface
import com.hsdesigns.caramelwallet.utils.listItemData


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
        initRecyclerview(listItemData)
    }
    private fun initRecyclerview(listOfItems: List<ListOfItemsDto>) {
        val listItemRecyclerviewAdapter = ListItemRecyclerViewAdapter(listOfItems)
        val recyclerview = binding.fragmentItemsListRV
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        recyclerview.adapter = listItemRecyclerviewAdapter
    }
}