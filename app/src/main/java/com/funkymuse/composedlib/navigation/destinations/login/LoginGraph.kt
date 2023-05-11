package com.funkymuse.composedlib.navigation.destinations.login

import com.funkymuse.composed.navigation.graph.NavigationGraph
import javax.inject.Inject

class LoginGraph @Inject constructor(override val startingDestination: LoginScreenDestination) : NavigationGraph {
    override val route: String = "LoginGraph"
}