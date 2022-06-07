package com.hsdesigns.caramelwallet.feature_dashboard.data.remote.dto

import com.hsdesigns.caramelwallet.feature_dashboard.domain.model.Products

data class ProductsDto(
    val id: String,
    val name: String,
    val amount: Int
){
    // function to map ProductsDto to Product
    fun toProducts(): Products{
        return Products(
            id = id,
            name = name,
            amount = amount
        )
    }
}


