package com.funkymuse.composedlib.navigation.destinations.bottom_sheets.cyan

import androidx.navigation.NamedNavArgument
import androidx.navigation.navArgument
import com.funkymuse.composed.navigation.destination.arguments.applyArgumentsToDestination
import com.funkymuse.composed.navigation.destination.arguments.asNonNullDestinationValue
import com.funkymuse.composed.navigation.destination.arguments.asRequiredArgument
import com.funkymuse.composed.navigation.destination.arguments.createDestination
import com.funkymuse.composed.navigation.destination.type.BottomSheetDestination
import com.funkymuse.composed.navigation.navargs.primitives.DestinationsIntNavType
import javax.inject.Inject

class CyanBottomSheetDialogDestination @Inject constructor() : BottomSheetDestination {

    companion object {
        const val ROUTE = "CyanBottomSheetDialogDestination"
        const val ID = "id"
    }

    override fun destination(): String = createDestination(ROUTE, ID.asRequiredArgument())

    fun openDestination(id: Int) = applyArgumentsToDestination(ROUTE, id.toString().asNonNullDestinationValue())
    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(ID) {
                type = DestinationsIntNavType
            }
        )
}