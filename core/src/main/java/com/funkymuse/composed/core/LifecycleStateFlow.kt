package com.funkymuse.composed.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

/**
 * Created by funkymuse on 4/12/21 to long live and prosper !
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

@Composable
fun <T> StateFlow<T>.collectAndRemember(
    initial: T,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED
): State<T> =
    rememberFlowWithLifecycle(flow = this, minActiveState = minActiveState).collectAsState(initial)


@Composable
fun <T> rememberFlowWithLifecycle(
    flow: Flow<T>,
    lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED
): Flow<T> = remember(flow, lifecycle) {
    flow.flowWithLifecycle(lifecycle, minActiveState)
}


@Composable
fun <T> Flow<T>.collectAndRemember(
    initial: T,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED
): State<T> =
    rememberFlowWithLifecycle(flow = this, minActiveState = minActiveState).collectAsState(initial)