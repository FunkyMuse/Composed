package com.funkymuse.composed.navigation.helpers

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.funkymuse.composed.core.stability_wrappers.StableHolder
import com.funkymuse.composed.navigation.arguments.previous_destination.AddArgumentsToPreviousDestination
import com.funkymuse.composed.navigation.getResultAsStateFlow
import com.funkymuse.composed.navigation.helpers.BooleanCallbackArguments.Companion.BOOLEAN_CALLBACK_ARG
import kotlinx.coroutines.flow.StateFlow

class BooleanCallbackArguments(override val navHostController: StableHolder<NavHostController>) : AddArgumentsToPreviousDestination {
    companion object {
        const val BOOLEAN_CALLBACK_ARG = "booleanCallbackArg"
    }

    fun setFalseCallback(key : String = BOOLEAN_CALLBACK_ARG) {
        set(key, false)
    }

    fun setTrueCallback(key: String = BOOLEAN_CALLBACK_ARG) {
        set(key, true)
    }

    override fun consumeArgumentsAtReceivingDestination() {
        consumeArgument(BOOLEAN_CALLBACK_ARG)
    }
}

fun NavBackStackEntry.getBooleanCallbackAsStateFlow(
    initialValue: Boolean,
): StateFlow<Boolean?> = getResultAsStateFlow(BOOLEAN_CALLBACK_ARG, initialValue)

fun NavBackStackEntry.getBooleanCallbackAsFlow(
    initialValue: Boolean,
): StateFlow<Boolean?> = getResultAsStateFlow(BOOLEAN_CALLBACK_ARG, initialValue)
