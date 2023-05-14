package com.funkymuse.composedlib.navigation

import android.util.Log
import androidx.navigation.NavOptionsBuilder
import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composed.navigation.NavigatorDirections
import com.funkymuse.composed.navigation.model.NavigatorIntent
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@Singleton
internal class NavigatorImpl @Inject constructor() : Navigator, NavigatorDirections {

    init {
        Log.d("NavigatorImpl", "CREATED")
    }

    private val navigationEvents = Channel<NavigatorIntent>(Channel.UNLIMITED)
    override val directions = navigationEvents.receiveAsFlow()

    override fun popCurrentBackStack() {
        navigationEvents.trySend(NavigatorIntent.PopCurrentBackStack)
    }

    override fun navigateUp() {
        navigationEvents.trySend(NavigatorIntent.NavigateUp)
    }

    override fun popBackStack(destination: String, inclusive: Boolean, saveState: Boolean) {
        navigationEvents.trySend(NavigatorIntent.PopBackStack(destination, inclusive, saveState))
    }

    override fun navigateTopLevel(destination: String) {
        navigationEvents.trySend(NavigatorIntent.NavigateTopLevel(destination))
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
