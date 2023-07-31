package com.funkymuse.composed.core

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import org.junit.Assert
import org.junit.Rule
import org.junit.Test


/**
 * Created by funkymuse on 4/12/21 to long live and prosper !
 */
internal class LifecycleExtensionsKtTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<ComponentActivity>()


    @Test
    fun testObserveLifecycle() {
        var isStarted = false
        val lifecycleObserver = object : DefaultLifecycleObserver {
            override fun onStart(owner: LifecycleOwner) {
                super.onStart(owner)
                isStarted = true
            }
        }
        composeRule.activityRule.scenario.moveToState(Lifecycle.State.STARTED)
        composeRule.setContent {
            lifecycleObserver.ObserveLifecycle()
        }
        composeRule.waitForIdle()
        Assert.assertTrue(isStarted)
    }
}