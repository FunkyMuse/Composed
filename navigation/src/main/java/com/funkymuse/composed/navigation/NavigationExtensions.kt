package com.funkymuse.composed.navigation

import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController

@Composable
fun NavHostController.rememberParentEntry(): NavBackStackEntry {
    // First, get the parent of the current destination
    // This always exists since every destination in your graph has a parent
    val parentId = currentBackStackEntry?.destination?.parent!!.id

    // Now get the NavBackStackEntry associated with the parent
    // making sure to remember it
    return remember {
        getBackStackEntry(parentId)
    }
}

fun <T> NavHostController.setResult(key: String, value: T) =
    previousBackStackEntry?.savedStateHandle?.set(key, value)

@Composable
fun <T> NavHostController.getResultAsState(key: String, initial: T): State<T> =
    getResultAsLiveData<T>(key = key)?.observeAsState(initial) ?: produceState(
        initialValue = initial,
        producer = {
            value = initial
        }
    )

@Composable
fun <T> NavHostController.getRememberedResult(key: String, initial: T): T {
    val result by getResultAsState(key, initial)
    val rememberedResult by remember {
        mutableStateOf(result)
    }
    return rememberedResult
}


@Composable
fun <T> NavHostController.getResultAsLiveData(key: String): LiveData<T>? =
    currentBackStackEntry?.savedStateHandle?.getLiveData(key)

@Composable
fun <T> NavHostController.getResult(key: String, defaultValue: T): T =
    currentBackStackEntry?.savedStateHandle?.get<T>(key) ?: defaultValue