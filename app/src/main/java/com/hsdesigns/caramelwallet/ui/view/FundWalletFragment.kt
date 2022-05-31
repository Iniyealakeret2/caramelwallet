package com.hsdesigns.caramelwallet.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hsdesigns.caramelwallet.R
import com.hsdesigns.caramelwallet.databinding.FragmentFundWalletBinding


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

}