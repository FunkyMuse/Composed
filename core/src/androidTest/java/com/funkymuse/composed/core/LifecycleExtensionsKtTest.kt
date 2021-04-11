package com.funkymuse.composed.core

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.lifecycle.Lifecycle
import com.funkymuse.composed.core.utils.MainCoroutineRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test


/**
 * Created by funkymuse on 4/12/21 to long live and prosper !
 */
internal class LifecycleExtensionsKtTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<ComponentActivity>()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Test
    fun onLifecycleEventCheck() {
        composeRule.activityRule.scenario.moveToState(Lifecycle.State.CREATED)

        val list = mutableListOf<Lifecycle.Event>()
        composeRule.setContent {
            OnLifecycleEvent { source, event ->
                assert(source is ComponentActivity)
                list.add(event)
            }
        }
        composeRule.waitForIdle()
        assertEquals(list.firstOrNull(), Lifecycle.Event.ON_CREATE)
    }

    @Test
    fun onCreateCheck() {
        stateChecker(Lifecycle.State.CREATED) {
            OnCreate {}
        }
    }

    @Test
    fun onStartCheck() {
        stateChecker(Lifecycle.State.STARTED) {
            OnStart {}
        }
    }

    @Test
    fun onResumeCheck() {
        stateChecker(Lifecycle.State.RESUMED) {
            OnResume {}
        }
    }

    private fun stateChecker(state: Lifecycle.State, action: @Composable () -> Unit) {
        composeRule.activityRule.scenario.moveToState(state)
        var isLifecycleCalled = false
        composeRule.setContent {
            val owner = lifecycleOwner
            action()
            assert(owner.lifecycle.currentState == state)
            isLifecycleCalled = true
        }
        composeRule.waitForIdle()
        assert(isLifecycleCalled)
    }


    @Test
    fun onLifecycleCheck() {
        composeRule.activityRule.scenario.moveToState(Lifecycle.State.CREATED)
        composeRule.setContent {
            OnLifecycle(onCreate = {
                assert(it is ComponentActivity)
                assert(it.lifecycle.currentState == Lifecycle.State.CREATED)
            }, onStart = {
                assert(it is ComponentActivity)
                assert(it.lifecycle.currentState == Lifecycle.State.STARTED)
            })
        }
    }
}