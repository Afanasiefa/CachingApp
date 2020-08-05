package com.example.testtask.dagger.modules

import com.example.testtask.api.NetworkService
import com.example.testtask.database.CompletePostDao
import com.example.testtask.repository.CompletePostRepository
import com.example.testtask.repository.DatabaseRepository
import com.example.testtask.utils.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun retrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(Constants.BASE_URL)
        .build()

    @Provides
    @Singleton
    fun retrofitService(retrofit: Retrofit): NetworkService = retrofit.create(
        NetworkService::class.java
    )

    @Provides
    @Singleton
    fun provideRemoteSource(
        api: NetworkService,
        completePostDao: CompletePostDao
    ): CompletePostRepository = CompletePostRepository(api, completePostDao)

    @Provides
    @Singleton
    fun getDatabaseRepository(dao: CompletePostDao): DatabaseRepository {
        return DatabaseRepository(dao)
    }
}