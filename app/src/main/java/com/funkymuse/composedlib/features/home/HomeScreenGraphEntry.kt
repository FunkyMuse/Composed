package com.funkymuse.composedlib.features.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.funkymuse.composed.core.stability_wrappers.StableHolder
import com.funkymuse.composed.navigation.destination.NavigationDestination
import com.funkymuse.composed.navigation.graph.NavigationGraphEntry
import com.funkymuse.composedlib.navigation.destinations.home.destinations.HomeScreenBottomNavDestination
import com.funkymuse.composedlib.navigation.destinations.home.directions.HomeScreenDirections
import javax.inject.Inject

internal class HomeScreenGraphEntry @Inject constructor(
    private val homeScreenDirections: HomeScreenDirections
) : NavigationGraphEntry {
    override val navigationDestination: NavigationDestination = HomeScreenBottomNavDestination

    @Composable
    override fun Render(controller: StableHolder<NavHostController>) {
        val homeViewModel = hiltViewModel<HomeViewModel>()
        HomeScreen(homeScreenDirections::openLogin)
    }
}