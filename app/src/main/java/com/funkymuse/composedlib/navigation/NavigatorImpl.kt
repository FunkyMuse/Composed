package com.funkymuse.composedlib.navigation

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

    private val _directions = Channel<NavigatorIntent>(Channel.BUFFERED)
    override val directions = _directions.receiveAsFlow()

    override fun popCurrentBackStack() {
        _directions.trySend(NavigatorIntent.PopCurrentBackStack)
    }

    override fun navigate(navigatorIntent: NavigatorIntent) {
        _directions.trySend(navigatorIntent)
    }

    override fun navigateUp() {
        _directions.trySend(NavigatorIntent.NavigateUp)
    }

    override fun popBackStack(destination: String, inclusive: Boolean, saveState: Boolean) {
        _directions.trySend(NavigatorIntent.PopBackStack(destination, inclusive, saveState))
    }

    override fun navigateTopLevel(destination: String) {
        _directions.trySend(NavigatorIntent.NavigateTopLevel(destination))
    }

    override fun navigate(destination: String, builder: NavOptionsBuilder.() -> Unit) {
        _directions.trySend(NavigatorIntent.Directions(destination, builder))
    }

    override fun navigateSingleTop(destination: String, builder: NavOptionsBuilder.() -> Unit) {
        _directions.trySend(NavigatorIntent.Directions(destination, builder))
    }

    override fun navigate(destination: String) {
        _directions.trySend(NavigatorIntent.Directions(destination))
    }
}
