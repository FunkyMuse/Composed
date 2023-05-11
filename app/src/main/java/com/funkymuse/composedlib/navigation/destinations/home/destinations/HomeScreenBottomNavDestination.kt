package com.funkymuse.composedlib.navigation.destinations.home.destinations

import androidx.navigation.NamedNavArgument
import com.funkymuse.composed.navigation.destination.type.ScreenDestination
import com.funkymuse.composed.navigation.showBottomNamedArgument

object HomeScreenBottomNavDestination : ScreenDestination {
    override fun destination(): String = "HomeScreenBottomNavDestination"
    override val arguments: List<NamedNavArgument>
        get() = listOf(showBottomNamedArgument)
}
