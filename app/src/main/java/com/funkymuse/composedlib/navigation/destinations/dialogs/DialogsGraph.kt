package com.funkymuse.composedlib.navigation.destinations.dialogs

import com.funkymuse.composed.navigation.graph.NavigationGraph
import com.funkymuse.composedlib.navigation.destinations.dialogs.yellow.YellowDialogDestination
import javax.inject.Inject

class DialogsGraph @Inject constructor(override val startingDestination: YellowDialogDestination) : NavigationGraph {
    override val route: String = "DialogsGraph"
}