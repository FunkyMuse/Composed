package com.funkymuse.composedlib.navigation.destinations.bottom_sheets.test

import androidx.compose.ui.window.DialogProperties
import com.funkymuse.composed.navigation.destination.NavigationDestination
import com.funkymuse.composed.navigation.destination.type.BottomSheetDestination
import com.funkymuse.composed.navigation.destination.type.DialogDestination
import javax.inject.Inject

class TestBottomSheetDialogDestination @Inject constructor() : BottomSheetDestination {
    override fun destination(): String = "TestBottomSheetDialogDestination"
}