package com.hsdesigns.caramelwallet.common.di

import com.hsdesigns.caramelwallet.common.data.db.CaramelWalletDatabase
import com.hsdesigns.caramelwallet.common.data.remote.CaramelWalletAPI
import com.hsdesigns.caramelwallet.feature_dashboard.data.repository.DashboardRepositoryImpl
import com.hsdesigns.caramelwallet.feature_dashboard.domain.repository.DashboardRepository
import com.hsdesigns.caramelwallet.feature_dashboard.domain.useCases.GetProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DashboardModule {

    @Provides
    @Singleton
    fun provideGetProductsUseCase(
        dashboardRepository: DashboardRepository
    ): GetProductsUseCase {
        return GetProductsUseCase(dashboardRepository)
    }

    @Provides
    @Singleton
    fun provideDashboardRepository(
        api: CaramelWalletAPI,
        db: CaramelWalletDatabase
    ): DashboardRepository{
        return DashboardRepositoryImpl(api, db.dao)
    }

}