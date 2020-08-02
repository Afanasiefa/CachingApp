package com.example.testtask.dagger

import com.example.testtask.database.PostDao
import com.example.testtask.network.post.SomeApi
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
        .addConverterFactory(GsonConverterFactory.create()) //converter tells Retrofit what to do with data it get from web service (convert json to kotlin objects)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL) // get Retrofit known with base url of service
        .build() // actually build an retrofit object

    @Provides
    @Singleton
    fun retrofitService(retrofit: Retrofit): SomeApi = retrofit.create(
        SomeApi::class.java)

    @Provides
    @Singleton
    fun provideRemoteSource(api: SomeApi, postDao: PostDao): NetworkRepository = NetworkRepository(api, postDao)

}