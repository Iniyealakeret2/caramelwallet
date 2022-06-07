package com.hsdesigns.caramelwallet.feature_dashboard.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hsdesigns.caramelwallet.feature_dashboard.domain.model.Products

@Entity
data class ProductEntity(
    @PrimaryKey
    val roomDbId: Int? = null,
    val id: String,
    val name: String,
    val amount: Int
){
    fun toProduct(): Products{
        return Products(
            id = id,
            name = name,
            amount = amount
        )
    }
}
