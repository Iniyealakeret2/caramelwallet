package com.hsdesigns.caramelwallet.feature_authentication.data.repository

import com.hsdesigns.caramelwallet.common.data.remote.CaramelWalletAPI
import com.hsdesigns.caramelwallet.common.utils.Resource
import com.hsdesigns.caramelwallet.feature_authentication.domain.model.LoginRequest
import com.hsdesigns.caramelwallet.feature_authentication.domain.model.LoginResponse
import com.hsdesigns.caramelwallet.feature_authentication.domain.repository.AuthenticationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    val api: CaramelWalletAPI
): AuthenticationRepository {

    override suspend fun login(loginRequest: LoginRequest): Flow<Resource<List<LoginResponse>>> = flow {
        emit(Resource.Loading())
        val loginResponse = api.login(loginRequest).map { it.toLoginResponse()}
        emit(Resource.Loading(data = loginResponse))
        try {
            api.login(loginRequest).map { it.toLoginResponse()}
        }catch (e: HttpException) {
            emit(Resource.Error(
                message = "Ops something went wrong",
                data = loginResponse
            ))
        }catch (IO: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = loginResponse
            ))
        }
        emit(Resource.Success(
            data = loginResponse
        ))
    }.flowOn(Dispatchers.IO)

}