package com.funkymuse.composedlib.navigation.destinations.bottom_sheets

import com.funkymuse.composed.navigation.graph.NavigationGraph
import com.funkymuse.composedlib.navigation.destinations.bottom_sheets.test.TestBottomSheetDialogDestination
import javax.inject.Inject

class BottomSheetsGraph @Inject constructor(override val startingDestination: TestBottomSheetDialogDestination) : NavigationGraph {
    override val route: String = "BottomSheetsGraph"
}