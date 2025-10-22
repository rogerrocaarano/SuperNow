package me.rogerroca.supernow.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.rogerroca.supernow.features.markets.data.IMarketsRepository
import me.rogerroca.supernow.features.markets.data.MarketsRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMarketsRepository(
        marketsRepository: MarketsRepositoryImpl
    ): IMarketsRepository
}