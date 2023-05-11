package com.funkymuse.composed.navigation

import androidx.compose.runtime.Stable
import androidx.navigation.NavOptionsBuilder
import com.funkymuse.composed.navigation.model.NavigatorIntent
import kotlinx.coroutines.flow.Flow

@Stable
interface Navigator {

    fun navigateUp()
    fun navigateSingleTop(
        destination: String,
        builder: NavOptionsBuilder.() -> Unit = { launchSingleTop = true },
    )

    fun navigate(
        destination: String,
    )

    fun popBackStack(
        destination: String,
        inclusive: Boolean,
        saveState: Boolean = false,
    )

    fun popCurrentBackStack()

    val destinations: Flow<NavigatorIntent>
}
