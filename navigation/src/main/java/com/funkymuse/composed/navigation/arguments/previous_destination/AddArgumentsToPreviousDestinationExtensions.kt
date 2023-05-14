package com.funkymuse.composed.navigation.arguments.previous_destination

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import com.funkymuse.composed.navigation.currentEntry

@Composable
fun <T> AddArgumentsToPreviousDestination.OnSingleCallbackArgument(
    key: String,
    initialValue: T? = null,
    onValue: (T?) -> Unit
) {
    val currentEntryHandle = navHostController.currentEntry.savedStateHandle
    val value by currentEntryHandle.getStateFlow(key, initialValue).collectAsState(initial = initialValue)
    val currentOnValue by rememberUpdatedState(newValue = onValue)
    LaunchedEffect(value) {
        currentOnValue(value)
        consumeArgument(key)
    }
}

@Composable
fun AddArgumentsToPreviousDestination.OnSingleBooleanCallbackArgument(
    key: String,
    initialValue: Boolean? = null,
    onValue: (Boolean?) -> Unit,
) = OnSingleCallbackArgument(key = key, initialValue = initialValue, onValue = onValue)

@Composable
fun AddArgumentsToPreviousDestination.OnSingleIntCallbackArgument(
    key: String,
    initialValue: Int? = null,
    onValue: (Int?) -> Unit,
) = OnSingleCallbackArgument(key = key, initialValue = initialValue, onValue = onValue)

@Composable
fun AddArgumentsToPreviousDestination.OnSingleStringCallbackArgument(
    key: String,
    initialValue: String? = null,
    onValue: (String?) -> Unit,
) = OnSingleCallbackArgument(key = key, initialValue = initialValue, onValue = onValue)

@Composable
fun AddArgumentsToPreviousDestination.OnSingleDoubleCallbackArgument(
    key: String,
    initialValue: Double? = null,
    onValue: (Double?) -> Unit,
) = OnSingleCallbackArgument(key = key, initialValue = initialValue, onValue = onValue)
