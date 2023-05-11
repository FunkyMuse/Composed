package com.funkymuse.composedlib.navigation

import androidx.navigation.NavOptionsBuilder
import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composed.navigation.NavigatorDestinations
import com.funkymuse.composed.navigation.model.NavigatorIntent
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

internal class NavigatorImpl @Inject constructor() : Navigator, NavigatorDestinations {

    private val navigationEvents = Channel<NavigatorIntent>(Channel.BUFFERED)
    override val destinations = navigationEvents.receiveAsFlow()

    override fun popCurrentBackStack() {
        navigationEvents.trySend(NavigatorIntent.PopCurrentBackStack)
    }

    override fun navigateUp() {
        navigationEvents.trySend(NavigatorIntent.NavigateUp)
    }

    override fun popBackStack(destination: String, inclusive: Boolean, saveState: Boolean) {
        navigationEvents.trySend(NavigatorIntent.PopBackStack(destination, inclusive, saveState))
    }

    override fun navigate(destination: String, builder: NavOptionsBuilder.() -> Unit) {
        navigationEvents.trySend(NavigatorIntent.Directions(destination, builder))
    }

    override fun navigateSingleTop(destination: String, builder: NavOptionsBuilder.() -> Unit) {
        navigationEvents.trySend(NavigatorIntent.Directions(destination, builder))
    }

    override fun navigate(destination: String) {
        navigationEvents.trySend(NavigatorIntent.Directions(destination))
    }
}
