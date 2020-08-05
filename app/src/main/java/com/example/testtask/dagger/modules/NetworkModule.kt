package com.example.testtask.dagger.modules

import com.example.testtask.api.NetworkService
import com.example.testtask.database.CompletePostDao
import com.example.testtask.repository.NetworkRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

@Module
class NetworkModule() {

    @Provides
    @Singleton
    fun retrofit() = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun retrofitService(retrofit: Retrofit): NetworkService = retrofit.create(
        NetworkService::class.java)

    @Provides
    @Singleton
    fun provideRemoteSource(api: NetworkService, completePostDao: CompletePostDao): NetworkRepository = NetworkRepository(api, completePostDao)

}