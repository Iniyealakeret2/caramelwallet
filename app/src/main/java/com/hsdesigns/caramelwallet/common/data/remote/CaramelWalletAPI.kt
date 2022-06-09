package com.hsdesigns.caramelwallet.common.data.remote

import com.hsdesigns.caramelwallet.feature_authentication.domain.model.LoginRequest
import com.hsdesigns.caramelwallet.feature_dashboard.data.remote.dto.ProductsDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CaramelWalletAPI {
    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest)

    @GET("videos/")
    suspend fun getAllProducts(): List<ProductsDto>
}