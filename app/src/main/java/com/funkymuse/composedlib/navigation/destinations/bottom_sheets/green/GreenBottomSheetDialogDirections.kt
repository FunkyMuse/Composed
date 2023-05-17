package com.funkymuse.composedlib.navigation.destinations.bottom_sheets.green

import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composedlib.navigation.destinations.bottom_sheets.cyan.CyanBottomSheetDialogDestination
import javax.inject.Inject

class GreenBottomSheetDialogDirections @Inject constructor(
    private val navigator: Navigator,
    private val cyanBottomSheetDialogDestination: CyanBottomSheetDialogDestination
) {
    fun openCyanDialog(
        id: Int
    ) = navigator.navigateSingleTop(cyanBottomSheetDialogDestination.openDestination(id))
}