package com.funkymuse.composedlib.features.dialogs.test2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.funkymuse.composed.core.stability_wrappers.StableHolder
import com.funkymuse.composed.navigation.Navigator
import com.funkymuse.composed.navigation.graph.NavigationGraphEntry
import com.funkymuse.composedlib.navigation.destinations.dialogs.test2.ArgumentsFromTest2Dialog
import com.funkymuse.composedlib.navigation.destinations.dialogs.test2.Test2DialogDestination
import javax.inject.Inject

internal class Test2DialogGraphEntry @Inject constructor(
    override val navigationDestination: Test2DialogDestination,
    private val navigator: Navigator
) :
    NavigationGraphEntry {
    @Composable
    override fun Render(controller: StableHolder<NavHostController>) {
        val test2DialogViewModel = hiltViewModel<Test2DialogViewModel>()
        val texts by test2DialogViewModel.texts.collectAsStateWithLifecycle()
        val argumentsFromTest2Dialog = remember { ArgumentsFromTest2Dialog(controller) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red.copy(alpha = 0.8f), RoundedCornerShape(24.dp)),
        ) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                content = {
                    item {
                        Button(
                            onClick = {
                                argumentsFromTest2Dialog.addText("Text argument sent back to Yellow")
                                navigator.navigateUp()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {
                            Text(
                                text = "Send arguments back", color = Color.White,
                            )
                        }
                    }
                    items(texts.orEmpty(), key = { it }) {
                        Text(text = it, color = Color.White)
                    }
                })
        }
    }
}