package com.funkymuse.composed.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable

/**
 * Created by FunkyMuse, date 2/28/21
 */

//region saveable
@Composable
fun rememberBooleanSaveableDefaultFalse() = rememberSaveable { mutableStateOf(false) }

@Composable
fun rememberBooleanSaveableDefaultTrue() = rememberSaveable { mutableStateOf(true) }

@Composable
fun rememberStringSaveableDefaultEmpty() = rememberSaveable { mutableStateOf("") }

@Composable
fun rememberIntSaveableDefaultMinusOne() = rememberSaveable { mutableStateOf(-1) }

@Composable
fun rememberIntSaveableDefaultZero() = rememberSaveable { mutableStateOf(0) }
//endregion


//region remember
@Composable
fun rememberStringDefaultEmpty() = remember { mutableStateOf("") }

@Composable
fun rememberBooleanDefaultFalse() = remember { mutableStateOf(false) }

@Composable
fun rememberBooleanDefaultTrue() = remember { mutableStateOf(true) }

@Composable
fun rememberIntDefaultMinusOne() = remember { mutableStateOf(-1) }

@Composable
fun rememberIntDefaultZero() = remember { mutableStateOf(0) }
//endregion