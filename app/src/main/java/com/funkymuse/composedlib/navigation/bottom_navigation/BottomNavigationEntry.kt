package com.funkymuse.composedlib.navigation.bottom_navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.funkymuse.composed.navigation.destination.NavigationDestination

sealed class BottomNavigationEntry(
    val destination: NavigationDestination,
     val text: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)
