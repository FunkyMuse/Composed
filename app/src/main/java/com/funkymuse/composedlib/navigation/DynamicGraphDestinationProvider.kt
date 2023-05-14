package com.funkymuse.composedlib.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.input.key.Key.Companion.Home
import com.funkymuse.composedlib.navigation.bottom_navigation.BottomNavigationEntry
import com.funkymuse.composedlib.navigation.destinations.favorites.destinations.FavoritesScreenBottomNavDestination
import com.funkymuse.composedlib.navigation.destinations.favorites.graph.FavoritesGraph
import com.funkymuse.composedlib.navigation.destinations.home.destinations.HomeScreenBottomNavDestination
import com.funkymuse.composedlib.navigation.destinations.home.graph.HomeGraph
import com.funkymuse.composedlib.navigation.destinations.settings.destinations.SettingsScreenBottomNavDestination
import com.funkymuse.composedlib.navigation.destinations.settings.graph.SettingsGraph
import com.funkymuse.composedlib.navigation.graphs.GraphFactory
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class DynamicGraphDestinationProvider @Inject constructor(
    private val graphFactory: GraphFactory,
) {

    private val homeGraph get() = graphFactory.getGraphByRoute<HomeGraph>(HomeGraph::class.java)
    private val favoritesGraph get() = graphFactory.getGraphByRoute<FavoritesGraph>(FavoritesGraph::class.java)
    private val settingsGraph get() = graphFactory.getGraphByRoute<SettingsGraph>(SettingsGraph::class.java)

    fun getStartingDestination(): String = homeGraph.route


    val bottomNavigationEntries = listOf(
        BottomNavigationEntry(
            destination = HomeScreenBottomNavDestination,
            text = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = homeGraph.route
        ),

        BottomNavigationEntry(
            destination = FavoritesScreenBottomNavDestination,
            text = "Favorites",
            selectedIcon = Icons.Default.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
            route = favoritesGraph.route
        ),
        BottomNavigationEntry(
            destination = SettingsScreenBottomNavDestination,
            text = "Settings",
            selectedIcon = Icons.Default.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            route = settingsGraph.route
        ),
    )
}
