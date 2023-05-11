package com.funkymuse.composed.navigation.destination.type

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Stable
import androidx.navigation.NavBackStackEntry
import com.funkymuse.composed.navigation.destination.NavigationDestination
import com.funkymuse.composed.navigation.destination.animation.AnimatedDestination

@Stable
interface ScreenDestination : NavigationDestination, AnimatedDestination {

    override val enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)?
        get() = null

    override val exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)?
        get() = null
}
