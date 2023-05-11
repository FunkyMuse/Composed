package com.funkymuse.composedlib.navigation.destinations.bottom_sheets.test

import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composedlib.navigation.destinations.bottom_sheets.test2.Test2BottomSheetDialogDestination
import javax.inject.Inject

class TestBottomSheetDialogDirections @Inject constructor(
    private val navigator: Navigator,
    private val test2BottomSheetDialogDestination: Test2BottomSheetDialogDestination
) {
    fun openTest2Dialog(
        id: Int
    ) = navigator.navigateSingleTop(test2BottomSheetDialogDestination.openDestination(id))
}