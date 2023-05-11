package com.funkymuse.composedlib.features.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.funkymuse.composed.core.stability_wrappers.StableHolder
import com.funkymuse.composed.navigation.destination.NavigationDestination
import com.funkymuse.composed.navigation.graph.NavigationGraphEntry
import com.funkymuse.composedlib.navigation.destinations.favorites.destinations.FavoritesScreenBottomNavDestination
import com.funkymuse.composedlib.navigation.destinations.home.destinations.HomeScreenBottomNavDestination
import com.funkymuse.composedlib.navigation.destinations.settings.destinations.SettingsScreenBottomNavDestination
import javax.inject.Inject

internal class SettingsScreenGraphEntry @Inject constructor() : NavigationGraphEntry {
    override val navigationDestination: NavigationDestination = SettingsScreenBottomNavDestination

    @Composable
    override fun Render(controller: StableHolder<NavHostController>) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Settings")
        }
    }
}