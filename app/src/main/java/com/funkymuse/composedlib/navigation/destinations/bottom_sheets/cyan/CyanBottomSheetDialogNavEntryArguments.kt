package com.funkymuse.composedlib.navigation.destinations.bottom_sheets.cyan

import androidx.navigation.NavBackStackEntry
import com.funkymuse.composed.navigation.arguments.nav_entry.NavigationEntryArguments
import com.funkymuse.composed.navigation.arguments.nav_entry.getIntArgument

class CyanBottomSheetDialogNavEntryArguments(override val currentNavBackStackEntry: NavBackStackEntry) : NavigationEntryArguments {

    val id = requireNotNull(getIntArgument(CyanBottomSheetDialogDestination.ID)){
        "CyanBottomSheetDialogNavEntryArguments ${CyanBottomSheetDialogDestination.ID} is a required parameter, must not be null"
    }
}