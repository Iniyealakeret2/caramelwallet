package com.hsdesigns.caramelwallet.feature_dashboard.domain.useCases

import com.hsdesigns.caramelwallet.common.utils.Resource
import com.hsdesigns.caramelwallet.feature_dashboard.domain.model.Products
import com.hsdesigns.caramelwallet.feature_dashboard.domain.repository.DashboardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val repository: DashboardRepository) {
    suspend operator fun invoke(): Flow<Resource<List<Products>>> = repository.getAllProducts()
}