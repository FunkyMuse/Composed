package com.funkymuse.composedlib.navigation.destinations.favorites.directions

import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composedlib.navigation.destinations.bottom_sheets.green.GreenBottomSheetDialogDestination
import com.funkymuse.composedlib.navigation.destinations.dialogs.yellow.YellowDialogDestination
import javax.inject.Inject

class FavoritesDirections @Inject constructor(
    private val navigator: Navigator,
    private val yellowDialogDestination: YellowDialogDestination,
    private val greenBottomSheetDialogDestination: GreenBottomSheetDialogDestination
) {
    fun openTestDialog() = navigator.navigateSingleTop(yellowDialogDestination.destination())
    fun openTestBottomSheet() = navigator.navigateSingleTop(greenBottomSheetDialogDestination.destination())
}