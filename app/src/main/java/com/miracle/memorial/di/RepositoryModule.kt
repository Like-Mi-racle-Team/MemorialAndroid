package com.miracle.memorial.di

import com.miracle.memorial.data.remote.api.LoginApi
import com.miracle.memorial.data.repository.LoginRepositoryImpl
import com.miracle.memorial.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideLoginRepository(
        api: LoginApi
    ): LoginRepository {
        return LoginRepositoryImpl(api)
    }

}