package com.hsdesigns.caramelwallet.feature_dashboard.domain.repository

import com.hsdesigns.caramelwallet.common.utils.Resource
import com.hsdesigns.caramelwallet.feature_dashboard.domain.model.Products
import kotlinx.coroutines.flow.Flow

interface DashboardRepository {
    suspend fun getAllProducts(): Flow<Resource<List<Products>>>
}