package com.funkymuse.composedlib.features.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.funkymuse.composed.core.stability_wrappers.StableHolder
import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composed.navigation.destination.NavigationDestination
import com.funkymuse.composed.navigation.graph.NavigationGraphEntry
import com.funkymuse.composedlib.navigation.destinations.home.destinations.HomeScreenBottomNavDestination
import com.funkymuse.composedlib.navigation.destinations.login.LoginScreenDestination
import javax.inject.Inject

internal class LoginScreenGraphEntry @Inject constructor(
    override val navigationDestination: LoginScreenDestination,
    private val navigator: Navigator
) :
    NavigationGraphEntry {

    @Composable
    override fun Render(controller: StableHolder<NavHostController>) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray.copy(alpha = 0.65f)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = navigator::navigateUp) {
                Text(text = "Go back")
            }
        }
    }
}