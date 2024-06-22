package com.example.testlime.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModules {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder ()
        .baseUrl("https://limeapi.online/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}