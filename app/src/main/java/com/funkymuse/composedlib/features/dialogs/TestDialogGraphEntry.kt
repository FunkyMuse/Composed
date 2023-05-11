package com.funkymuse.composedlib.features.dialogs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.funkymuse.composed.core.stability_wrappers.StableHolder
import com.funkymuse.composed.navigation.arguments.previous_destination.OnSingleStringCallbackArgument
import com.funkymuse.composed.navigation.graph.NavigationGraphEntry
import com.funkymuse.composedlib.navigation.destinations.dialogs.test.TestDialogDestination
import com.funkymuse.composedlib.navigation.destinations.dialogs.test.TestDialogDirections
import com.funkymuse.composedlib.navigation.destinations.dialogs.test2.ArgumentsFromTest2Dialog
import javax.inject.Inject

internal class TestDialogGraphEntry @Inject constructor(
    override val navigationDestination: TestDialogDestination,
    private val testDialogDirections: TestDialogDirections
) : NavigationGraphEntry {
    @Composable
    override fun Render(controller: StableHolder<NavHostController>) {
        var callbackString by remember { mutableStateOf<String?>(null) }
        val argumentsFromTest2Dialog = remember { ArgumentsFromTest2Dialog(controller) }
        argumentsFromTest2Dialog
            .OnSingleStringCallbackArgument(key = ArgumentsFromTest2Dialog.TEXT, onValue = {
                callbackString = it
            })
        Column(
            modifier = Modifier
                .fillMaxHeight(0.6f)
                .fillMaxWidth(0.6f)
                .background(Color.Yellow.copy(alpha = 0.9f), RoundedCornerShape(16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                testDialogDirections.openTest2Dialog(
                    arrayOf(
                        "Navigation",
                        "Compose",
                        "Something",
                        "Dialog",
                    )
                )
            }) {
                Text(text = "Open other dialog")
            }
            AnimatedVisibility(
                visible = !callbackString.isNullOrEmpty(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Callback string $callbackString",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}