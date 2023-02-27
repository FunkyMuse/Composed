package com.funkymuse.composed.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * Created by FunkyMuse, date 4/12/21
 */

/**
 * This function gives event callbacks from the [LifecycleEventObserver]
 * @param action
 */
@Composable
inline fun OnLifecycleEvent(crossinline action: (source: LifecycleOwner, event: Lifecycle.Event) -> Unit) {
    val observer = LifecycleEventObserver { source, event -> action(source, event) }
    AddLifecycleObserver(observer)
}

/**
 * Callbacks onCreate propagated from [DefaultLifecycleObserver]
 * @param action
 */
@Composable
fun OnCreate(action: (source: LifecycleOwner) -> Unit) {
    OnLifecycle(onCreate = action)
}

/**
 * Callbacks onStart propagated from [DefaultLifecycleObserver]
 * @param action
 */
@Composable
fun OnStart(action: (source: LifecycleOwner) -> Unit) {
    OnLifecycle(onStart = action)
}

/**
 * Callbacks onResume propagated from [DefaultLifecycleObserver]
 * @param action
 */
@Composable
fun OnResume(action: (source: LifecycleOwner) -> Unit) {
    OnLifecycle(onResume = action)
}

/**
 * Callbacks onPause propagated from [DefaultLifecycleObserver]
 * @param action
 */
@Composable
fun OnPause(action: (source: LifecycleOwner) -> Unit) {
    OnLifecycle(onPause = action)
}

/**
 * Callbacks onStop propagated from [DefaultLifecycleObserver]
 * @param action
 */
@Composable
fun OnStop(action: (source: LifecycleOwner) -> Unit) {
    OnLifecycle(onStop = action)
}

/**
 * Callbacks onDestroy propagated from [DefaultLifecycleObserver]
 * @param action
 */
@Composable
fun OnDestroy(action: (source: LifecycleOwner) -> Unit) {
    OnLifecycle(onDestroy = action)
}

/**
 * Callbacks propagated from [DefaultLifecycleObserver]
 * @param onCreate
 * @param onStart
 * @param onResume
 * @param onPause
 * @param onStop
 * @param onDestroy
 */
@Composable
fun OnLifecycle(
    onCreate: ((source: LifecycleOwner) -> Unit)?=null,
    onStart: ((source: LifecycleOwner) -> Unit)?=null,
    onResume: ((source: LifecycleOwner) -> Unit)?=null,
    onPause: ((source: LifecycleOwner) -> Unit)?=null,
    onStop: ((source: LifecycleOwner) -> Unit)?=null,
    onDestroy: ((source: LifecycleOwner) -> Unit)?=null,
) {
    val observer = object : DefaultLifecycleObserver {
        override fun onCreate(owner: LifecycleOwner) {
            onCreate?.invoke(owner)
        }

        override fun onStart(owner: LifecycleOwner) {
            onStart?.invoke(owner)
        }

        override fun onResume(owner: LifecycleOwner) {
            onResume?.invoke(owner)
        }

        override fun onPause(owner: LifecycleOwner) {
            onPause?.invoke(owner)
        }

        override fun onStop(owner: LifecycleOwner) {
            onStop?.invoke(owner)
        }

        override fun onDestroy(owner: LifecycleOwner) {
            onDestroy?.invoke(owner)
        }
    }
    AddLifecycleObserver(observer)
}

@Composable
fun AddLifecycleObserver(observer: LifecycleObserver) {
    val owner = lifecycleOwner.lifecycle
    DisposableEffect(owner) {
        owner.addObserver(observer)
        onDispose {
            owner.removeObserver(observer)
        }
    }
}

@Composable
fun OnLifecycleEvent(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onEvent: (event: Lifecycle.Event) -> Unit
) {
    val currentOnEvent by rememberUpdatedState(onEvent)
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            currentOnEvent(event)
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}

@Composable
fun <OWNER : LifecycleObserver> OWNER.ObserveLifecycle(lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle) {
    DisposableEffect(lifecycle) {
        lifecycle.addObserver(this@ObserveLifecycle)
        onDispose {
            lifecycle.removeObserver(this@ObserveLifecycle)
        }
    }
}