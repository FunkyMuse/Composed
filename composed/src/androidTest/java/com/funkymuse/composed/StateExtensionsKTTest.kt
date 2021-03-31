package com.funkymuse.composed

import androidx.compose.runtime.getValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.lifecycle.Lifecycle
import kotlinx.coroutines.flow.flowOf
import org.junit.Rule
import org.junit.Test

/**
 * Created by Hristijan, date 3/31/21
 */
class StateExtensionsKTTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testStateWhenStarted(){
        composeRule.setContent {
            TODO()
            val flow = flowOf(listOf("test, test, test"))
            val state by stateWhenStarted(flow = flow, initial = emptyList())
            assert(!state.isNullOrEmpty())
            assert(lifecycleOwner().lifecycle.currentState == Lifecycle.State.STARTED)
        }
    }
}