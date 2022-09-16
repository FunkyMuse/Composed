package com.funkymuse.composed.core

import androidx.annotation.PluralsRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext

inline infix fun (() -> Unit).andThen(crossinline function: () -> Unit): () -> Unit = {
    this()
    function()
}


@Composable
fun DisposableEffectRunOnlyOnce(
    onDispose: (() -> Unit)? = null,
    disposables: () -> Unit
) {
    DisposableEffect(Unit) {
        disposables()
        onDispose { onDispose?.invoke() }
    }
}


@Composable
fun pluralRes(
    @PluralsRes id: Int,
    quantity: Int,
    vararg formatArgs: Any? = emptyArray()
): String = LocalContext.current.resources.getQuantityString(id, quantity, *formatArgs)
