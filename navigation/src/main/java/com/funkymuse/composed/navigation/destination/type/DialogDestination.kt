package com.funkymuse.composed.navigation.destination.type

import androidx.compose.runtime.Stable
import androidx.compose.ui.window.DialogProperties
import com.funkymuse.composed.navigation.destination.NavigationDestination

@Stable
interface DialogDestination : NavigationDestination {
    val dialogProperties: DialogProperties
}
