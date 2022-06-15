package com.hsdesigns.caramelwallet.feature_authentication.domain.repository

import com.hsdesigns.caramelwallet.common.utils.Resource
import com.hsdesigns.caramelwallet.feature_authentication.domain.model.LoginRequest
import com.hsdesigns.caramelwallet.feature_authentication.domain.model.LoginResponse
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {
    suspend fun login(loginRequest: LoginRequest): Flow<Resource<List<LoginResponse>>>
}