package com.funkymuse.composedlib.navigation.destinations.login

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavBackStackEntry
import com.funkymuse.composed.navigation.destination.type.ScreenDestination
import javax.inject.Inject

class LoginScreenDestination @Inject constructor() : ScreenDestination {
    override fun destination(): String = "LoginScreenDestination"

    override val enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)
        get() = {
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Up)
        }

    override val exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)
        get() =  {
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Down)
        }
}