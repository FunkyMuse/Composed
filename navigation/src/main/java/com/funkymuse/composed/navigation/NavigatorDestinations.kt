package com.funkymuse.composed.navigation

import androidx.compose.runtime.Immutable
import com.funkymuse.composed.navigation.model.NavigatorIntent
import kotlinx.coroutines.flow.Flow

@Immutable
interface NavigatorDestinations {

    val destinations: Flow<NavigatorIntent>
}