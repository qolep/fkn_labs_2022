package ru.marvel.effectiveLabs.di

import ru.marvel.effectiveLabs.navigation.AppNavigationImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.marvel.effectiveLabs.data.network.NetworkService
import ru.marvel.effectiveLabs.data.network.NetworkServiceImpl
import ru.marvel.effectiveLabs.navigation.AppNavigation
import ru.marvel.effectiveLabs.data.repository.Repository
import ru.marvel.effectiveLabs.data.repository.RepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideNavigation(): AppNavigation = AppNavigationImpl()

    @Singleton
    @Provides
    fun provideRepository(
        network: NetworkService,
    ): Repository = RepositoryImpl(network)

    @Singleton
    @Provides
    fun provideNetwork(): NetworkService = NetworkServiceImpl()
}
