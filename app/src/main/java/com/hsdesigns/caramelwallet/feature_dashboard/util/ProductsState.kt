package com.hsdesigns.caramelwallet.feature_dashboard.util

import com.hsdesigns.caramelwallet.feature_dashboard.domain.model.Products

data class ProductsState(
    val products: List<Products> = emptyList(),
    val isLoading: Boolean = false
)
