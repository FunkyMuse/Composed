package com.funkymuse.composed.navigation.graph

import androidx.compose.runtime.Immutable
import com.funkymuse.composed.navigation.destination.NavigationDestination

@Immutable
interface NavigationGraph {
    val startingDestination: NavigationDestination
    val route: String
}
