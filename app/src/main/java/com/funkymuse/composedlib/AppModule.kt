package com.funkymuse.composedlib

import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composed.navigation.NavigatorDirections
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
    abstract fun bindNavigator(navigatorImpl: NavigatorImpl): Navigator

    @Binds
    abstract fun bindNavigatorDestination(navigatorImpl: NavigatorImpl): NavigatorDirections


}