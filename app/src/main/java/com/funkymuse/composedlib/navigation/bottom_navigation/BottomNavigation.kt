package com.funkymuse.composedlib.navigation.bottom_navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.funkymuse.composedlib.navigation.destinations.favorites.destinations.FavoritesScreenBottomNavDestination
import com.funkymuse.composedlib.navigation.destinations.home.destinations.HomeScreenBottomNavDestination
import com.funkymuse.composedlib.navigation.destinations.settings.destinations.SettingsScreenBottomNavDestination

internal object Home : BottomNavigationEntry(
    destination = HomeScreenBottomNavDestination,
    text = "Home",
    selectedIcon = Icons.Filled.Home,
    unselectedIcon = Icons.Outlined.Home,
)

internal object Favorites : BottomNavigationEntry(
    destination = FavoritesScreenBottomNavDestination,
    text = "Favorites",
    selectedIcon = Icons.Default.Favorite,
    unselectedIcon = Icons.Outlined.FavoriteBorder,
)

internal object Settings : BottomNavigationEntry(
    destination = SettingsScreenBottomNavDestination,
    text = "Settings",
    selectedIcon = Icons.Default.Settings,
    unselectedIcon = Icons.Outlined.Settings,
)

val bottomNavigationEntries: Set<BottomNavigationEntry> =
    setOf(
        Home,
        Favorites,
        Settings,
    )

@Composable
internal fun BottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    navBackStackEntry: NavBackStackEntry?,
    hideBottomNav: Boolean,
) {
    AnimatedVisibility(
        visible = !hideBottomNav,
        enter = slideInVertically { it },
        exit = slideOutVertically { it },
        modifier = modifier.fillMaxWidth(),
    ) {
        BottomAppBar(modifier = Modifier.fillMaxWidth()) {
            bottomNavigationEntries.forEach { bottomEntry ->
                val isSelected = navBackStackEntry?.destination?.route == bottomEntry.destination.destination()
                NavigationBarItem(
                    selected = isSelected,
                    alwaysShowLabel = true,
                    onClick = {
                        navController.navigate(bottomEntry.destination.destination()) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            navController.graph.findStartDestination().route?.let {
                                popUpTo(it) {
                                    saveState = true
                                }
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item zimi kurov
                            restoreState = true
                        }
                    },
                    label = {
                        Text(
                            modifier = Modifier
                                .wrapContentSize(unbounded = true),
                            softWrap = false,
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            text = bottomEntry.text,
                        )
                    },
                    icon = {
                        Crossfade(targetState = isSelected, label = "bottom-nav-icon") { isSelectedIcon ->
                            if (isSelectedIcon) {
                                Icon(imageVector = bottomEntry.selectedIcon, contentDescription = bottomEntry.text)
                            } else {
                                Icon(imageVector = bottomEntry.unselectedIcon, contentDescription = bottomEntry.text)
                            }
                        }
                    },
                )
            }
        }
    }
}
