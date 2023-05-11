package com.funkymuse.composedlib.navigation.destinations.favorites.graph

import com.funkymuse.composed.navigation.destination.NavigationDestination
import com.funkymuse.composed.navigation.graph.NavigationGraph
import com.funkymuse.composedlib.navigation.destinations.favorites.destinations.FavoritesScreenBottomNavDestination
import javax.inject.Inject

class FavoritesGraph @Inject constructor() : NavigationGraph {
    override val startingDestination: NavigationDestination = FavoritesScreenBottomNavDestination
    override val route: String = "FavoritesGraph"
}
