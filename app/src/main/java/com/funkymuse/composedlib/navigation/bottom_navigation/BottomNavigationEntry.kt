package com.funkymuse.composedlib.navigation.bottom_navigation

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import com.funkymuse.composed.navigation.destination.NavigationDestination

@Immutable
data class BottomNavigationEntry(
    val destination: NavigationDestination,
    val text: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String
)
