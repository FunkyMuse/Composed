package com.funkymuse.composed.navigation.arguments.previous_destination

import androidx.compose.runtime.Immutable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController
import com.funkymuse.composed.core.stability_wrappers.StableHolder

/**
 * Name should start ArgumentsFromXDestination where X destination is the one you're sending arguments from
 */
@Immutable
interface AddArgumentsToPreviousDestination {
    val navHostController: StableHolder<NavHostController>
    fun consumeArgumentsAtReceivingDestination()
    private val currentBackStackEntrySavedStateHandle: SavedStateHandle?
        get() = navHostController.item.currentBackStackEntry?.savedStateHandle
    private val previousBackStackEntrySavedStateHandle: SavedStateHandle?
        get() = navHostController.item.previousBackStackEntry?.savedStateHandle

    fun <T> addArgumentToNavEntry(route: String, key: String, value: T?) {
        navHostController.item.getBackStackEntry(route).savedStateHandle[key] = value
    }

    fun consumeArgument(key: String) {
        currentBackStackEntrySavedStateHandle?.set(key, null)
    }

    fun <T> set(key: String, value: T?) {
        previousBackStackEntrySavedStateHandle?.set(key, value)
    }

    fun consumeArguments(vararg key: String) {
        key.forEach(::consumeArgument)
    }
}
