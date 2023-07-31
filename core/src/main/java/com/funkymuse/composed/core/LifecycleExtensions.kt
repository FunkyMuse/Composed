package com.funkymuse.composed.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

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
fun <OWNER : LifecycleObserver> OWNER.ObserveLifecycle(lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle) {
    DisposableEffect(lifecycle) {
        lifecycle.addObserver(this@ObserveLifecycle)
        onDispose {
            lifecycle.removeObserver(this@ObserveLifecycle)
        }
    }
}