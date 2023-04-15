package com.example.repository.remote.http.di

import com.example.repository.remote.http.datasources.CatDataSource
import com.example.repository.remote.http.interfaces.ICatDataSource
import com.example.repository.remote.http.services.CatService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideCatDataSource(api: CatService): ICatDataSource = CatDataSource(api)
}
