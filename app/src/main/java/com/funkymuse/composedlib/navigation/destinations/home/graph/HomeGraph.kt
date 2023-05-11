package com.funkymuse.composedlib.navigation.destinations.home.graph

import com.funkymuse.composed.navigation.destination.NavigationDestination
import com.funkymuse.composed.navigation.graph.NavigationGraph
import com.funkymuse.composedlib.navigation.destinations.home.destinations.HomeScreenBottomNavDestination
import javax.inject.Inject

class HomeGraph @Inject constructor() : NavigationGraph {
    override val startingDestination: NavigationDestination = HomeScreenBottomNavDestination
    override val route: String = "HomeGraph"
}
