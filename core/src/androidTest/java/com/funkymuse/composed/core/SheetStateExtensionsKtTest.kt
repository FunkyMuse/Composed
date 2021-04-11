package com.funkymuse.composed.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.junit.Rule

import org.junit.Test

/**
 * Created by funkymuse on 3/24/21 to long live and prosper !
 */
class SheetStateExtensionsKtTest {

    @get:Rule
    val rule = createComposeRule()

    @OptIn(ExperimentalMaterialApi::class)
    @Test
    fun bottom_sheet_state_toggle_hidden_to_visible() {
        lateinit var scope: CoroutineScope
        lateinit var state : ModalBottomSheetState
        rule.setContent {
            scope = rememberCoroutineScope()
            state = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
            ModalBottomSheetLayout(sheetContent = {
               Box(modifier = Modifier.fillMaxSize())
            }, sheetState = state) {
                Box(modifier = Modifier.fillMaxSize())
            }
        }

        val job = scope.launch {
            state.toggle()
        }

        rule.waitUntil { job.isCompleted }
        assert(state.isVisible)
        scope.cancel()
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Test
    fun drawer_state_toggle_closed_to_open() {
        lateinit var scope: CoroutineScope
        lateinit var state : DrawerState
        rule.setContent {
            scope = rememberCoroutineScope()
            state = rememberDrawerState(initialValue = DrawerValue.Closed)
            ModalDrawer(drawerContent = {
               Box(modifier = Modifier.fillMaxSize())
            }, drawerState = state) {
                Box(modifier = Modifier.fillMaxSize())
            }
        }

        val job = scope.launch {
            state.toggle()
        }

        rule.waitUntil { job.isCompleted }
        assert(state.isOpen)
        scope.cancel()
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Test
    fun bottom_drawer_state_toggle_closed_to_open() {
        lateinit var scope: CoroutineScope
        lateinit var state : DrawerState
        lateinit var bottomSheetScaffoldState: BottomSheetScaffoldState
        rule.setContent {
            scope = rememberCoroutineScope()
            state = rememberDrawerState(initialValue = DrawerValue.Closed)
            bottomSheetScaffoldState = rememberBottomSheetScaffoldState(drawerState = state)
            BottomSheetScaffold(drawerContent = {
               Box(modifier = Modifier.fillMaxSize())
            }, sheetContent = {}, scaffoldState = bottomSheetScaffoldState) {
                Box(modifier = Modifier.fillMaxSize())
            }
        }

        val job = scope.launch {
            bottomSheetScaffoldState.toggleDrawerState()
        }

        rule.waitUntil { job.isCompleted }
        assert(state.isOpen)
        scope.cancel()
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Test
    fun dismiss_Snack() {
        lateinit var scope: CoroutineScope
        lateinit var bottomSheetScaffoldState: BottomSheetScaffoldState

        rule.setContent {
            scope = rememberCoroutineScope()
            bottomSheetScaffoldState = rememberBottomSheetScaffoldState()

            BottomSheetScaffold(drawerContent = {
               Box(modifier = Modifier.fillMaxSize())
            }, sheetContent = {}, snackbarHost = {
                scope.launch { it.showSnackbar("", duration = SnackbarDuration.Indefinite) }
            }, scaffoldState = bottomSheetScaffoldState) {
                Box(modifier = Modifier.fillMaxSize())
            }
        }

        val job = scope.launch {
            bottomSheetScaffoldState.dismissSnack()
        }

        rule.waitUntil { job.isCompleted }
        assert(bottomSheetScaffoldState.snackbarHostState.currentSnackbarData == null)
        scope.cancel()
    }



}


