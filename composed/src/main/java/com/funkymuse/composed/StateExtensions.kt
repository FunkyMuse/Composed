package com.funkymuse.composed

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

/**
 * Created by FunkyMuse, date 2/28/21
 */

@Composable
fun rememberBooleanSaveableDefaultFalse() = rememberSaveable { mutableStateOf(false) }

@Composable
fun rememberBooleanSaveableDefaultTrue() = rememberSaveable { mutableStateOf(true) }

@Composable
fun rememberStringSaveableDefaultEmpty() = rememberSaveable { mutableStateOf("") }