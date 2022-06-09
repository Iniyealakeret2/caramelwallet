package com.hsdesigns.caramelwallet.common.di

import android.app.Application
import androidx.room.Room
import com.hsdesigns.caramelwallet.common.data.db.CaramelWalletDatabase
import com.hsdesigns.caramelwallet.common.data.remote.CaramelWalletAPI
import com.hsdesigns.caramelwallet.common.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CaramelWalletModule {

    @Provides
    @Singleton
    fun provideCaramelWalletDatabase(application: Application): CaramelWalletDatabase{
        return Room.databaseBuilder(
            application,
            CaramelWalletDatabase::class.java,
            "products_db"
        ).build()
    }

    @AuthInterceptorOkHttpClient
    @Provides
    @Singleton
    fun providesOkhttp(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(30L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)
            .writeTimeout(30L, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor).build()

    @Provides
    @Singleton
    fun provideLogger(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideCaramelWalletAPI(
        @AuthInterceptorOkHttpClient okHttpClient: OkHttpClient
    ): CaramelWalletAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(CaramelWalletAPI::class.java)
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AuthInterceptorOkHttpClient
}

