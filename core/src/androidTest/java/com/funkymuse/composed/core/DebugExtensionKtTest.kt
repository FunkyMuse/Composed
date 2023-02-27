package com.funkymuse.composed.core

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import junit.framework.TestCase.assertEquals
import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test


class DebugExtensionKtTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun logCompositionTest() {
        rule.setContent {
            var recompositionCount by remember { mutableStateOf(0) }
            LogCompositions {
                recompositionCount = it + 1
            }
            assertEquals(1, recompositionCount)
        }
    }
}