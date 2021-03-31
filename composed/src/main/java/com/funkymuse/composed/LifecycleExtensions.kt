package com.funkymuse.composed

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Created by FunkyMuse, date 3/31/21
 */

@Composable
fun <T> stateWhenStarted(
    flow: Flow<T>,
    initial: T,
    context: CoroutineContext = EmptyCoroutineContext
): State<T> {
    val lifecycleOwner = LocalLifecycleOwner.current
    val flowLifecycleAware = remember(flow, lifecycleOwner) {
        flow.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
    }
    return flowLifecycleAware.collectAsState(initial, context)
}

@Composable
fun <T> stateWhenResumed(
    flow: Flow<T>,
    initial: T,
    context: CoroutineContext = EmptyCoroutineContext
): State<T> {
    val lifecycleOwner = LocalLifecycleOwner.current
    val flowLifecycleAware = remember(flow, lifecycleOwner) {
        flow.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.RESUMED)
    }
    return flowLifecycleAware.collectAsState(initial, context)
}