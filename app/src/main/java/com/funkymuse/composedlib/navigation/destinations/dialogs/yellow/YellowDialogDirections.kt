package com.funkymuse.composedlib.navigation.destinations.dialogs.yellow

import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composedlib.navigation.destinations.dialogs.red.RedDialogDestination
import javax.inject.Inject

class YellowDialogDirections @Inject constructor(
    private val navigator: Navigator,
    private val redDialogDestination: RedDialogDestination
) {
    fun openRedDialog(
        texts : Array<String>
    ) = navigator.navigateSingleTop(redDialogDestination.openDestination(texts))
}