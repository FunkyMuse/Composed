package com.funkymuse.composedlib.navigation.destinations.dialogs.test

import androidx.compose.ui.window.DialogProperties
import com.funkymuse.composed.navigation.destination.NavigationDestination
import com.funkymuse.composed.navigation.destination.type.DialogDestination
import javax.inject.Inject

class TestDialogDestination @Inject constructor() : DialogDestination {
    override val dialogProperties: DialogProperties
        get() = DialogProperties(usePlatformDefaultWidth = false)

    override fun destination(): String = "TestDialogDestination"
}