package com.funkymuse.composedlib.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.dialog
import com.funkymuse.composed.core.stability_wrappers.StableHolder
import com.funkymuse.composed.navigation.destination.animation.AnimatedDestination
import com.funkymuse.composed.navigation.destination.type.BottomSheetDestination
import com.funkymuse.composed.navigation.destination.type.DialogDestination
import com.funkymuse.composed.navigation.destination.type.ScreenDestination
import com.funkymuse.composed.navigation.graph.NavigationGraph
import com.funkymuse.composed.navigation.graph.NavigationGraphEntry
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.bottomSheet

fun NavGraphBuilder.addGraphs(
    navController: StableHolder<NavHostController>,
    navigationGraphs: Map<NavigationGraph, Set<NavigationGraphEntry>>,
    showAnimations: Boolean,
) {
    navigationGraphs.forEach { (navigatorGraph, destinationGraphEntries) ->
        navigation(startDestination = navigatorGraph.startingDestination.destination(), route = navigatorGraph.route) {
            destinationGraphEntries.forEach { destinationGraphEntry ->
                addDestinationBasedOnType(destinationGraphEntry, navController, showAnimations)
            }
        }
    }
}

private fun NavGraphBuilder.addDestinationBasedOnType(
    navigationGraphEntry: NavigationGraphEntry,
    navController: StableHolder<NavHostController>,
    showAnimations: Boolean,
) {
    when (navigationGraphEntry.navigationDestination) {
        is DialogDestination -> addDialogDestinations(navController, navigationGraphEntry)
        is ScreenDestination -> addComposableDestinations(navController, navigationGraphEntry, showAnimations)
        is BottomSheetDestination -> addBottomSheetDestinations(navController, navigationGraphEntry)
    }
}

@OptIn(ExperimentalMaterialNavigationApi::class)
private fun NavGraphBuilder.addBottomSheetDestinations(navController: StableHolder<NavHostController>, entry: NavigationGraphEntry) {
    val destination = entry.navigationDestination
    bottomSheet(destination.destination(), destination.arguments, destination.deepLinks) {
        entry.Render(navController)
    }
}

private fun NavGraphBuilder.addDialogDestinations(navController: StableHolder<NavHostController>, entry: NavigationGraphEntry) {
    val destination = entry.navigationDestination as DialogDestination
    dialog(
        destination.destination(),
        destination.arguments,
        destination.deepLinks,
        destination.dialogProperties,
    ) {
        entry.Render(navController)
    }
}

private fun NavGraphBuilder.addComposableDestinations(
    navController: StableHolder<NavHostController>,
    entry: NavigationGraphEntry,
    showAnimations: Boolean,
) {
    val destination = entry.navigationDestination
    if (destination is AnimatedDestination && showAnimations) {
        composable(
            destination.destination(),
            destination.arguments,
            destination.deepLinks,
            destination.enterTransition,
            destination.exitTransition,
            destination.popEnterTransition,
            destination.popExitTransition,
        ) {
            entry.Render(navController)
        }
    } else {
        composable(
            destination.destination(),
            destination.arguments,
            destination.deepLinks,
        ) {
            entry.Render(navController)
        }
    }
}
