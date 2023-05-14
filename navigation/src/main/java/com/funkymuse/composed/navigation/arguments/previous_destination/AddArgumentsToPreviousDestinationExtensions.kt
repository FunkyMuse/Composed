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
    consumeWhen: (T?) -> Boolean = { it != null },
    onValue: (T?) -> Unit
) {
    val currentEntryHandle = navHostController.currentEntry.savedStateHandle
    val value by currentEntryHandle.getStateFlow(key, initialValue).collectAsState(initial = initialValue)
    val currentOnValue by rememberUpdatedState(newValue = onValue)
    LaunchedEffect(value) {
        currentOnValue(value)
        if (consumeWhen(value)) {
            consumeArgument(key)
        }
    }
}

@Composable
fun AddArgumentsToPreviousDestination.OnSingleBooleanCallbackArgument(
    key: String,
    initialValue: Boolean? = null,
    consumeWhen: (Boolean?) -> Boolean = { it != null },
    onValue: (Boolean?) -> Unit,
) = OnSingleCallbackArgument(key = key, initialValue = initialValue, onValue = onValue, consumeWhen = consumeWhen)

@Composable
fun AddArgumentsToPreviousDestination.OnSingleIntCallbackArgument(
    key: String,
    initialValue: Int? = null,
    consumeWhen: (Int?) -> Boolean = { it != null },
    onValue: (Int?) -> Unit,
) = OnSingleCallbackArgument(key = key, initialValue = initialValue, onValue = onValue, consumeWhen = consumeWhen)

@Composable
fun AddArgumentsToPreviousDestination.OnSingleStringCallbackArgument(
    key: String,
    initialValue: String? = null,
    consumeWhen: (String?) -> Boolean = { it != null },
    onValue: (String?) -> Unit,
) = OnSingleCallbackArgument(key = key, initialValue = initialValue, onValue = onValue, consumeWhen = consumeWhen)

@Composable
fun AddArgumentsToPreviousDestination.OnSingleDoubleCallbackArgument(
    key: String,
    initialValue: Double? = null,
    consumeWhen: (Double?) -> Boolean = { it != null },
    onValue: (Double?) -> Unit,
) = OnSingleCallbackArgument(key = key, initialValue = initialValue, onValue = onValue, consumeWhen = consumeWhen)
