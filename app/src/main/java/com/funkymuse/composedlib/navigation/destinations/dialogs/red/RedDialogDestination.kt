package com.funkymuse.composedlib.navigation.destinations.dialogs.red

import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NamedNavArgument
import androidx.navigation.navArgument
import com.funkymuse.composed.navigation.destination.addStringArrayArgument
import com.funkymuse.composed.navigation.destination.arguments.applyArgumentsToDestination
import com.funkymuse.composed.navigation.destination.arguments.asNullWithDestinationValue
import com.funkymuse.composed.navigation.destination.arguments.asOptionalArgument
import com.funkymuse.composed.navigation.destination.arguments.createDestination
import com.funkymuse.composed.navigation.destination.type.DialogDestination
import com.funkymuse.composed.navigation.navargs.primitives.array.DestinationsStringArrayNavType
import javax.inject.Inject

class RedDialogDestination @Inject constructor() : DialogDestination {

    companion object {
        const val ROUTE = "RedDialogDestination"
        const val TEXTS = "texts"
    }

    override val dialogProperties: DialogProperties
        get() = DialogProperties()

    override fun destination(): String = createDestination(ROUTE, TEXTS.asOptionalArgument())

    fun openDestination(texts: Array<String>) = applyArgumentsToDestination(
        ROUTE, TEXTS.asNullWithDestinationValue(
            addStringArrayArgument(texts)
        ),
    )

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(TEXTS) {
                type = DestinationsStringArrayNavType
                nullable = true
                defaultValue = null
            },
        )
}