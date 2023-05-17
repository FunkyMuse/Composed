package com.funkymuse.composedlib.features.bottom_sheets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.funkymuse.composed.core.stability_wrappers.StableHolder
import com.funkymuse.composed.navigation.currentEntry
import com.funkymuse.composed.navigation.graph.NavigationGraphEntry
import com.funkymuse.composedlib.navigation.destinations.bottom_sheets.cyan.CyanBottomSheetDialogDestination
import com.funkymuse.composedlib.navigation.destinations.bottom_sheets.cyan.CyanBottomSheetDialogNavEntryArguments
import javax.inject.Inject

internal class CyanBottomSheetDialogGraphEntry @Inject constructor(
    override val navigationDestination: CyanBottomSheetDialogDestination
) :
    NavigationGraphEntry {
    @Composable
    override fun Render(controller: StableHolder<NavHostController>) {
        val args = remember { CyanBottomSheetDialogNavEntryArguments(controller.currentEntry) }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan.copy(alpha = 0.8f)),
        ) {
            Text(
                text = "Sheet dialog with argument id=${args.id}",
                modifier = Modifier.padding(24.dp)
            )
        }
    }
}