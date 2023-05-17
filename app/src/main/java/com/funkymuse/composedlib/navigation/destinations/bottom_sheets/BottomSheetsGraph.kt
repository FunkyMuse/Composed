package com.funkymuse.composedlib.navigation.destinations.bottom_sheets

import com.funkymuse.composed.navigation.graph.NavigationGraph
import com.funkymuse.composedlib.navigation.destinations.bottom_sheets.green.GreenBottomSheetDialogDestination
import javax.inject.Inject

class BottomSheetsGraph @Inject constructor(override val startingDestination: GreenBottomSheetDialogDestination) : NavigationGraph {
    override val route: String = "BottomSheetsGraph"
}