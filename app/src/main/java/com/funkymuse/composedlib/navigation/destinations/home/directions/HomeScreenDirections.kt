package com.funkymuse.composedlib.navigation.destinations.home.directions

import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composedlib.navigation.destinations.login.LoginScreenDestination
import javax.inject.Inject

class HomeScreenDirections @Inject constructor(
    private val navigator: Navigator,
    private val loginScreenDestination: LoginScreenDestination
) {

    fun openLogin() = navigator.navigateSingleTop(loginScreenDestination.destination())
}