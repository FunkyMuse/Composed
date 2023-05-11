package com.funkymuse.composed.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.navigation.NavHostController
import com.funkymuse.composed.core.stability_wrappers.StableHolder
import com.funkymuse.composed.navigation.destination.NavigationDestination

/**
 * This is a graph entry, accompanied and added to a parent [NavigationGraph]
 * @property navigationDestination NavigationDestination - the destination that controls arguments, deep links, animations, dialog properties
 * @property Render - where you can host all the logic your screen will get
 */
@Immutable
interface NavigationGraphEntry {
    val navigationDestination: NavigationDestination
    @Composable
    fun Render(controller: StableHolder<NavHostController>)
}
