package com.funkymuse.composed.navigation

import androidx.compose.runtime.Immutable
import androidx.navigation.NavOptionsBuilder

@Immutable
interface Navigator {

    fun navigateUp()
    fun navigateSingleTop(
        destination: String,
        builder: NavOptionsBuilder.() -> Unit = { launchSingleTop = true },
    )

    fun navigate(
        destination: String,
    )

    fun navigateTopLevel(
        destination: String,
    )

    fun navigate(
        destination: String,
        builder: NavOptionsBuilder.() -> Unit,
    )

    fun popBackStack(
        destination: String,
        inclusive: Boolean,
        saveState: Boolean = false,
    )

    fun popCurrentBackStack()

}
