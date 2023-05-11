package com.funkymuse.composedlib.navigation.destinations.dialogs

import com.funkymuse.composed.navigation.graph.NavigationGraph
import com.funkymuse.composedlib.navigation.destinations.dialogs.test.TestDialogDestination
import javax.inject.Inject

class DialogsGraph @Inject constructor(override val startingDestination: TestDialogDestination) : NavigationGraph {
    override val route: String = "DialogsGraph"
}