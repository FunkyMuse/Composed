package com.funkymuse.composedlib

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.funkymuse.composed.core.stability_wrappers.asStable
import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composed.navigation.NavigatorDestinations
import com.funkymuse.composed.navigation.graph.NavigationGraph
import com.funkymuse.composed.navigation.graph.NavigationGraphEntry
import com.funkymuse.composed.navigation.hideBottomNavigation
import com.funkymuse.composed.navigation.model.NavigatorIntent
import com.funkymuse.composedlib.navigation.DynamicGraphDestinationProvider
import com.funkymuse.composedlib.navigation.graphs.GraphFactory
import com.funkymuse.composedlib.navigation.addGraphs
import com.funkymuse.composedlib.navigation.bottom_navigation.BottomNavigation
import com.funkymuse.composedlib.ui.theme.ComposedLibTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var navigatorDestinations: NavigatorDestinations
    @Inject lateinit var graphFactory: GraphFactory
    @Inject lateinit var dynamicGraphDestinationProvider: DynamicGraphDestinationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposedLibTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppScaffold(
                        startingDestination = dynamicGraphDestinationProvider.getStartingDestination(),
                        graphs = {
                            graphFactory.graphsWithDestinations
                        },
                        showAnimations = true,
                        navigatorDestinations = navigatorDestinations
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
private fun AppScaffold(
    startingDestination: String,
    graphs: () -> Map<NavigationGraph, Set<NavigationGraphEntry>>,
    showAnimations: Boolean,
    navigatorDestinations: NavigatorDestinations,
) {
    val bottomSheetNavigator: BottomSheetNavigator = rememberBottomSheetNavigator()
    val navController: NavHostController = rememberAnimatedNavController(bottomSheetNavigator)

    val navBackStackEntry: NavBackStackEntry? by navController.currentBackStackEntryFlow.collectAsStateWithLifecycle(null)
    val hideFab: Boolean by remember {
        derivedStateOf { navBackStackEntry.hideBottomNavigation }
    }
    val currentRoute by remember {
        derivedStateOf { navBackStackEntry?.destination?.route }
    }
    LaunchedEffect(currentRoute) {
        Log.d(
            "Current destination", "${navBackStackEntry?.destination} with arguments ${navBackStackEntry?.arguments}",
        )
    }

    ModalBottomSheetLayout(
        modifier = Modifier.fillMaxSize(),
        bottomSheetNavigator = bottomSheetNavigator,
        sheetShape = MaterialTheme.shapes.large.copy(topStart = CornerSize(16.dp), topEnd = CornerSize(16.dp)),
        sheetElevation = 0.dp,
        sheetBackgroundColor = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ) {
                AnimatedNavHost(
                    navController = navController,
                    startDestination = startingDestination,
                    enterTransition = { fadeIn() },
                    exitTransition = { fadeOut() },
                ) {
                    addGraphs(navController.asStable, graphs(), showAnimations)
                }

                BottomNavigation(
                    modifier = Modifier.align(Alignment.BottomStart),
                    navController = navController,
                    hideBottomNav = hideFab,
                    navBackStackEntry = navBackStackEntry,
                )
            }
        }
    }
    NavHostControllerEvents(
        navigator = navigatorDestinations,
        navController = navController,
    )
}

@Composable
private fun NavHostControllerEvents(
    navigator: NavigatorDestinations,
    navController: NavHostController,
) {
    LaunchedEffect(navController) {
        navigator.destinations.collectLatest { navigatorEvent ->
            when (navigatorEvent) {
                is NavigatorIntent.NavigateUp -> navController.navigateUp()
                is NavigatorIntent.Directions -> navController.navigate(navigatorEvent.destination, navigatorEvent.builder)
                NavigatorIntent.PopCurrentBackStack -> navController.popBackStack()
                is NavigatorIntent.PopBackStack -> navController.popBackStack(
                    navigatorEvent.route,
                    navigatorEvent.inclusive,
                    navigatorEvent.saveState,
                )
            }
        }
    }
}