package com.funkymuse.composedlib.features.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.funkymuse.composed.core.stability_wrappers.StableHolder
import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composed.navigation.graph.NavigationGraphEntry
import com.funkymuse.composedlib.navigation.destinations.login.LoginScreenDestination
import javax.inject.Inject

internal class LoginScreenGraphEntry @Inject constructor(
    override val navigationDestination: LoginScreenDestination,
    private val navigator: Navigator
) : NavigationGraphEntry {

    @Composable
    override fun Render(controller: StableHolder<NavHostController>) {
        LoginScreen(navigator::navigateUp)
    }
}