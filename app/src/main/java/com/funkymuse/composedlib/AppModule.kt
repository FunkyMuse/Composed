package com.funkymuse.composedlib

import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composed.navigation.NavigatorDestinations
import com.funkymuse.composedlib.navigation.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindNavigator(navigatorImpl: NavigatorImpl): Navigator

    @Binds
    @Singleton
    abstract fun bindNavigatorDestination(navigatorImpl: NavigatorImpl): NavigatorDestinations


}