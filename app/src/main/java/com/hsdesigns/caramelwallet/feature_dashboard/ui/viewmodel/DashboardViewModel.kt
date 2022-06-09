package com.hsdesigns.caramelwallet.feature_dashboard.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hsdesigns.caramelwallet.common.utils.Resource
import com.hsdesigns.caramelwallet.feature_dashboard.domain.model.Products
import com.hsdesigns.caramelwallet.feature_dashboard.domain.useCases.GetProductsUseCase
import com.hsdesigns.caramelwallet.feature_dashboard.util.ProductsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
): ViewModel() {
    private var _state = MutableLiveData<Resource<List<Products>>>()
    val state: LiveData<Resource<List<Products>>> get() = _state


    fun getAllProducts(){
        viewModelScope.launch {
            getProductsUseCase.invoke().collect {
                _state.value = it
            }
        }
    }
}