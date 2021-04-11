package com.funkymuse.composed.core

import androidx.compose.runtime.*
import androidx.lifecycle.*

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
    onCreate: (source: LifecycleOwner) -> Unit = {},
    onStart: (source: LifecycleOwner) -> Unit = {},
    onResume: (source: LifecycleOwner) -> Unit = {},
    onPause: (source: LifecycleOwner) -> Unit = {},
    onStop: (source: LifecycleOwner) -> Unit = {},
    onDestroy: (source: LifecycleOwner) -> Unit = {},
) {
    val observer = object : DefaultLifecycleObserver {
        override fun onCreate(owner: LifecycleOwner) {
            onCreate(owner)
        }

        override fun onStart(owner: LifecycleOwner) {
            onStart(owner)
        }

        override fun onResume(owner: LifecycleOwner) {
            onResume(owner)
        }

        override fun onPause(owner: LifecycleOwner) {
            onPause(owner)
        }

        override fun onStop(owner: LifecycleOwner) {
            onStop(owner)
        }

        override fun onDestroy(owner: LifecycleOwner) {
            onDestroy(owner)
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
