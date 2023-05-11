package com.funkymuse.composedlib.navigation.destinations.bottom_sheets.test2

import androidx.navigation.NavBackStackEntry
import com.funkymuse.composed.navigation.arguments.nav_entry.NavigationEntryArguments
import com.funkymuse.composed.navigation.arguments.nav_entry.getIntArgument

class Test2BottomSheetDialogNavEntryArguments(override val currentNavBackStackEntry: NavBackStackEntry) : NavigationEntryArguments {

    val id = requireNotNull(getIntArgument(Test2BottomSheetDialogDestination.ID)){
        "Test2BottomSheetDialogNavEntryArguments ${Test2BottomSheetDialogDestination.ID} is a required parameter, must not be null"
    }
}