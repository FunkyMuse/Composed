package com.funkymuse.composedlib.navigation.destinations.dialogs.test

import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composedlib.navigation.destinations.dialogs.test2.Test2DialogDestination
import javax.inject.Inject

class TestDialogDirections @Inject constructor(
    private val navigator: Navigator,
    private val test2DialogDestination: Test2DialogDestination
) {
    fun openTest2Dialog(
        texts : Array<String>
    ) = navigator.navigateSingleTop(test2DialogDestination.openDestination(texts))
}