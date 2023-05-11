package com.funkymuse.composedlib.navigation.destinations.settings.graph

import com.funkymuse.composed.navigation.destination.NavigationDestination
import com.funkymuse.composed.navigation.graph.NavigationGraph
import com.funkymuse.composedlib.navigation.destinations.settings.destinations.SettingsScreenBottomNavDestination
import javax.inject.Inject

class SettingsGraph @Inject constructor() : NavigationGraph {
    override val startingDestination: NavigationDestination = SettingsScreenBottomNavDestination
    override val route: String = "SettingsGraph"
}
