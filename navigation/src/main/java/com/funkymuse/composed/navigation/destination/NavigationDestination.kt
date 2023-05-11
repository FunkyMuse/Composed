package com.funkymuse.composed.navigation.destination

import androidx.compose.runtime.Stable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink

@Stable
interface NavigationDestination {

    fun destination(): String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val deepLinks: List<NavDeepLink>
        get() = emptyList()
}
