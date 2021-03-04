package com.givekesh.movies.di.modules

import com.givekesh.movies.data.source.MainRepository
import com.givekesh.movies.data.source.remote.NetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMainRepository(networkApi: NetworkApi) = MainRepository(networkApi)
}