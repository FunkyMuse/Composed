package com.funkymuse.composed.core

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.lifecycle.Lifecycle
import com.funkymuse.composed.core.utils.MainCoroutineRule
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

/**
 * Created by Hristijan, date 3/31/21
 */
class LifecycleStateFlowExtensionsKTTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<ComponentActivity>()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Test
    fun testStateWhenStarted() {
        composeRule.activityRule.scenario.moveToState(Lifecycle.State.STARTED)
        val flow = MutableStateFlow(emptyList<String>())
        val testList = listOf("123", "456", "789")
        lateinit var state: List<String>
        composeRule.setContent {
            flow.value = testList
            state = stateWhenStarted(flow = flow, initial = emptyList()).value
            assert(lifecycleOwner.lifecycle.currentState == Lifecycle.State.STARTED)
        }

        assertEquals(state, testList)
        assertTrue(state.isNotEmpty())
    }

    @Test
    fun testStateWhenResumed() {
        composeRule.activityRule.scenario.moveToState(Lifecycle.State.RESUMED)
        val flow = MutableStateFlow(emptyList<String>())
        val testList = listOf("123", "456", "789")
        lateinit var state: List<String>
        composeRule.setContent {
            flow.value = testList
            state = stateWhenStarted(flow = flow, initial = emptyList()).value
            assert(lifecycleOwner.lifecycle.currentState == Lifecycle.State.RESUMED)
        }

        assertEquals(state, testList)
        assertTrue(state.isNotEmpty())
    }
}