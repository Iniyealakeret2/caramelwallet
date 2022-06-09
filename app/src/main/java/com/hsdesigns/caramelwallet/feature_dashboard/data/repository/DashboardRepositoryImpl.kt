package com.hsdesigns.caramelwallet.feature_dashboard.data.repository

import com.hsdesigns.caramelwallet.common.data.local.CaramelWalletDao
import com.hsdesigns.caramelwallet.common.data.remote.CaramelWalletAPI
import com.hsdesigns.caramelwallet.common.utils.Resource
import com.hsdesigns.caramelwallet.feature_dashboard.domain.model.Products
import com.hsdesigns.caramelwallet.feature_dashboard.domain.repository.DashboardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DashboardRepositoryImpl @Inject constructor(
    private val api: CaramelWalletAPI,
    private val dao: CaramelWalletDao
): DashboardRepository {
    // using caching here
    override suspend fun getAllProducts(): Flow<Resource<List<Products>>> = flow{
        emit(Resource.Loading())
        val products = api.getAllProducts().map { it.toProducts()}
        emit(Resource.Loading(data = products))
        try {
            val remoteProducts = api.getAllProducts()
            dao.deleteProductFromDB()
            dao.insertProducts(remoteProducts.map { it.toProductEntity()})
        }catch (e: HttpException){
            emit(Resource.Error(
                message = "Ops something went wrong",
                data = products
            ))
        }catch (e:IOException){
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = products
            ))
        }
        val newProducts = dao.getProductsFromDB().map { it.toProductEntity()}
        emit(Resource.Success(
            data = newProducts
        ))
    }.flowOn(Dispatchers.IO)
}