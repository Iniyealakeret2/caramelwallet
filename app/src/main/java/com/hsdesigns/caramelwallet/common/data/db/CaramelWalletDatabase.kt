package com.hsdesigns.caramelwallet.common.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hsdesigns.caramelwallet.common.data.local.CaramelWalletDao
import com.hsdesigns.caramelwallet.feature_dashboard.data.local.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class CaramelWalletDatabase: RoomDatabase() {
    abstract val dao: CaramelWalletDao
}