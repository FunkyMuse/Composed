package com.funkymuse.composedlib.features.favorites

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.funkymuse.composed.core.stability_wrappers.StableHolder
import com.funkymuse.composed.navigation.destination.NavigationDestination
import com.funkymuse.composed.navigation.graph.NavigationGraphEntry
import com.funkymuse.composedlib.navigation.destinations.favorites.destinations.FavoritesScreenBottomNavDestination
import com.funkymuse.composedlib.navigation.destinations.favorites.directions.FavoritesDirections
import javax.inject.Inject

internal class FavoritesScreenGraphEntry @Inject constructor(
    private val favoritesDirections: FavoritesDirections
) : NavigationGraphEntry {
    override val navigationDestination: NavigationDestination = FavoritesScreenBottomNavDestination

    @Composable
    override fun Render(controller: StableHolder<NavHostController>) {
        val favoritesViewModel = hiltViewModel<FavoritesViewModel>()
        val testItems by favoritesViewModel.testFlow.collectAsStateWithLifecycle()
        Log.d("FavoritesScreen", testItems.toString())
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Favorites")
            Button(onClick = favoritesDirections::openTestBottomSheet) {
                Text(text = "Bottom sheet")
            }
            Button(onClick = favoritesDirections::openTestDialog) {
                Text(text = "Dialog")
            }
        }
    }
}