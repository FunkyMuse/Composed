package com.funkymuse.composedlib.navigation.destinations.dialogs.yellow

import androidx.compose.ui.window.DialogProperties
import com.funkymuse.composed.navigation.destination.type.DialogDestination
import javax.inject.Inject

class YellowDialogDestination @Inject constructor() : DialogDestination {
    override val dialogProperties: DialogProperties
        get() = DialogProperties(usePlatformDefaultWidth = false)

    override fun destination(): String = "YellowDialogDestination"
}