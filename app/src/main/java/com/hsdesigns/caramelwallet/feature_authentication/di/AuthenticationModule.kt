package com.hsdesigns.caramelwallet.feature_authentication.di

import com.hsdesigns.caramelwallet.common.data.remote.CaramelWalletAPI
import com.hsdesigns.caramelwallet.feature_authentication.data.repository.AuthenticationRepositoryImpl
import com.hsdesigns.caramelwallet.feature_authentication.domain.repository.AuthenticationRepository
import com.hsdesigns.caramelwallet.feature_authentication.domain.useCases.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthenticationModule {

    @Provides
    @Singleton
    fun provideLoginUseCase(
        authenticationRepository: AuthenticationRepository
    ): LoginUseCase{
        return LoginUseCase(repository = authenticationRepository)
    }

    @Provides
    @Singleton
    fun provideAuthenticationRepository(
        api: CaramelWalletAPI
    ): AuthenticationRepository{
        return AuthenticationRepositoryImpl(api = api)
    }
}