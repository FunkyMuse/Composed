package com.funkymuse.composedlib.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = homeScreenDirections::openLogin) {
                Text(text = "Login")
            }
        }
    }
}