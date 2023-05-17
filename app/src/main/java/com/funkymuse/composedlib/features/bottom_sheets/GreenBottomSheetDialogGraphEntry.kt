package com.funkymuse.composedlib.features.bottom_sheets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.funkymuse.composed.core.stability_wrappers.StableHolder
import com.funkymuse.composed.navigation.graph.NavigationGraphEntry
import com.funkymuse.composedlib.navigation.destinations.bottom_sheets.green.GreenBottomSheetDialogDestination
import com.funkymuse.composedlib.navigation.destinations.bottom_sheets.green.GreenBottomSheetDialogDirections
import javax.inject.Inject
import kotlin.random.Random

internal class GreenBottomSheetDialogGraphEntry @Inject constructor(
    override val navigationDestination: GreenBottomSheetDialogDestination,
    private val testDialogDirections: GreenBottomSheetDialogDirections
) : NavigationGraphEntry {
    @Composable
    override fun Render(controller: StableHolder<NavHostController>) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green.copy(alpha = 0.9f)),
        ) {
            Button(onClick = {
                testDialogDirections.openCyanDialog(Random.nextInt(1, Int.MAX_VALUE))
            }) {
                Text(text = "Open other bottom sheet dialog", modifier = Modifier.padding(24.dp))
            }
        }
    }
}