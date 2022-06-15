package com.hsdesigns.caramelwallet.feature_authentication.domain.useCases

import com.hsdesigns.caramelwallet.common.utils.Resource
import com.hsdesigns.caramelwallet.feature_authentication.domain.model.LoginRequest
import com.hsdesigns.caramelwallet.feature_authentication.domain.model.LoginResponse
import com.hsdesigns.caramelwallet.feature_authentication.domain.repository.AuthenticationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(val repository: AuthenticationRepository) {
    suspend operator fun invoke(loginRequest: LoginRequest): Flow<Resource<List<LoginResponse>>> =
        repository.login(loginRequest)
}