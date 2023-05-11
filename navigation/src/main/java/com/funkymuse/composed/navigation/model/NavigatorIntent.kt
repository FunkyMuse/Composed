package com.funkymuse.composed.navigation.model

import androidx.compose.runtime.Stable
import androidx.navigation.NavOptionsBuilder

@Stable
sealed interface NavigatorIntent {
    object NavigateUp : NavigatorIntent
    object PopCurrentBackStack : NavigatorIntent
    data class PopBackStack(
        val route: String,
        val inclusive: Boolean,
        val saveState: Boolean = false,
    ) : NavigatorIntent

    class Directions(
        val destination: String,
        val builder: NavOptionsBuilder.() -> Unit = {},
    ) : NavigatorIntent {
        override fun toString(): String = "destination=$destination"
    }
}

val String.asDirectionsSingleTop: NavigatorIntent.Directions
    get() = NavigatorIntent.Directions(this) {
        launchSingleTop = true
    }
val String.asDirections: NavigatorIntent.Directions get() = NavigatorIntent.Directions(this)