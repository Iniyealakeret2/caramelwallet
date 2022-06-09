package com.hsdesigns.caramelwallet.common.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hsdesigns.caramelwallet.feature_dashboard.data.local.entity.ProductEntity

@Dao
interface CaramelWalletDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(product: List<ProductEntity>)

    @Query("SELECT * FROM products")
    suspend fun getProductsFromDB(): List<ProductEntity>

    @Query("DELETE FROM products")
    suspend fun deleteProductFromDB()
}