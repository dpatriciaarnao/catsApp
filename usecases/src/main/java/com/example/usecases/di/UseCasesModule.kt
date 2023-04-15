package com.example.usecases.di

import android.content.Context
import com.example.repository.remote.http.interfaces.ICatDataSource
import com.example.usecases.http.CatUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {
    @Singleton
    @Provides
    fun provideCatUseCase(
        @ApplicationContext context: Context,
        catDataSource: ICatDataSource
    ): CatUseCase = CatUseCase(
        context,
        catDataSource
    )
}
