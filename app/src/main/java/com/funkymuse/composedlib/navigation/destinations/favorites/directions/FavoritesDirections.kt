package com.funkymuse.composedlib.navigation.destinations.favorites.directions

import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composedlib.navigation.destinations.bottom_sheets.test.TestBottomSheetDialogDestination
import com.funkymuse.composedlib.navigation.destinations.dialogs.test.TestDialogDestination
import javax.inject.Inject

class FavoritesDirections @Inject constructor(
    private val navigator: Navigator,
    private val testDialogDestination: TestDialogDestination,
    private val testBottomSheetDialogDestination: TestBottomSheetDialogDestination
) {
    fun openTestDialog() = navigator.navigateSingleTop(testDialogDestination.destination())
    fun openTestBottomSheet() = navigator.navigateSingleTop(testBottomSheetDialogDestination.destination())
}