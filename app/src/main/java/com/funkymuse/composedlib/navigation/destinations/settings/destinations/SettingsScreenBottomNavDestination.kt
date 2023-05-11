package com.funkymuse.composedlib.navigation.destinations.settings.destinations

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import com.funkymuse.composed.navigation.destination.type.ScreenDestination
import com.funkymuse.composed.navigation.showBottomNamedArgument

object SettingsScreenBottomNavDestination : ScreenDestination {
    override fun destination(): String = "SettingsScreenBottomNavDestination"
    override val arguments: List<NamedNavArgument>
        get() = listOf(showBottomNamedArgument)

    override val enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)?
        get() = {
            slideInHorizontally(tween())
        }

    override val exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)?
        get() =  {
            slideOutVertically(tween()) { -it }
        }
}
