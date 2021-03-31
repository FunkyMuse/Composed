package com.funkymuse.composed

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.test.junit4.StateRestorationTester
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Hristijan, date 3/5/21
 */
class StateExtensionsKtTest {

    @get:Rule
    val rule = createComposeRule()

    private val restorationTester = StateRestorationTester(rule)

    @Test
    fun rememberBooleanSaveableDefaultFalseCheck() {
        val state = createState { rememberBooleanSaveableDefaultFalse() }
        assertNotNull(state)
        assertEquals(state, false)
    }


    @Test
    fun rememberBooleanSaveableDefaultTrueCheck() {
        val state = createState { rememberBooleanSaveableDefaultTrue() }
        assertNotNull(state)
        assertEquals(state, true)
    }

    @Test
    fun rememberStringSaveableDefaultEmptyCheck() {
        val state = createState { rememberStringSaveableDefaultEmpty() }
        assertNotNull(state)
        assertEquals(state, "")
    }


    @Test
    fun rememberIntSaveableDefaultMinusOneCheck() {
        val state = createState { rememberIntSaveableDefaultMinusOne() }
        assertNotNull(state)
        assertEquals(state, -1)
    }

    @Test
    fun rememberIntSaveableDefaultZeroCheck() {
        val state = createState { rememberIntSaveableDefaultZero() }
        assertNotNull(state)
        assertEquals(state, 0)
    }

    @Test
    fun rememberStringDefaultEmptyCheck() {
        val state = createState { rememberStringDefaultEmpty() }
        assertNotNull(state)
        assertEquals(state, "")
    }

    @Test
    fun rememberBooleanDefaultTrueCheck() {
        val state = createState { rememberBooleanDefaultTrue() }
        assertNotNull(state)
        assertEquals(state, true)
    }

    @Test
    fun rememberBooleanDefaultFalseCheck() {
        val state = createState { rememberBooleanDefaultFalse() }
        assertNotNull(state)
        assertEquals(state, false)
    }

    @Test
    fun rememberIntDefaultMinusOneCheck() {
        val state = createState { rememberIntDefaultMinusOne() }
        assertNotNull(state)
        assertEquals(state, -1)
    }

    @Test
    fun rememberIntDefaultZeroCheck() {
        val state = createState { rememberIntDefaultZero() }
        assertNotNull(state)
        assertEquals(state, 0)
    }


    private fun <T> createState(initializer: @Composable () -> MutableState<T>): T? {
        var state: T? = null
        restorationTester.setContent {
            state = initializer().value
        }
        return state
    }

}