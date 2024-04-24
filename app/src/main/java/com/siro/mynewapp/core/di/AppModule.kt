package com.siro.mynewapp.core.di

import android.content.Context
import com.siro.mynewapp.domain.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    @Singleton
    fun provideHomeRepository(
        @ApplicationContext context: Context,
    ): HomeRepository = HomeRepository(context)
}