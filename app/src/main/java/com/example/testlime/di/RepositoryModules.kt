package com.example.testlime.di

import com.example.testlime.data.TvDownloadRepositoryRetrofit
import com.example.testlime.domain.TvDownloadRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModules {

    @Binds
    @Singleton
    abstract fun bindTvDownloadRepository(
        tvDownloadRepository: TvDownloadRepositoryRetrofit
    ): TvDownloadRepository

}