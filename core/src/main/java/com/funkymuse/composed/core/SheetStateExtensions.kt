package com.funkymuse.composed.core

import androidx.compose.material.*

/**
 * Created by funkymuse on 3/24/21 to long live and prosper !
 */

@OptIn(ExperimentalMaterialApi::class)
suspend fun BottomSheetState.toggle() {
    if (isCollapsed) expand() else collapse()
}

@ExperimentalMaterialApi
suspend fun BottomDrawerState.toggle() {
    if (isClosed) open() else close()
}

suspend fun DrawerState.toggle() {
    if (isClosed) open() else close()
}

@OptIn(ExperimentalMaterialApi::class)
suspend fun BottomSheetScaffoldState.toggleSheetState() {
    bottomSheetState.toggle()
}

@OptIn(ExperimentalMaterialApi::class)
suspend fun BottomSheetScaffoldState.toggleDrawerState() {
    drawerState.toggle()
}

@OptIn(ExperimentalMaterialApi::class)
fun BottomSheetScaffoldState.dismissSnack() {
    snackbarHostState.currentSnackbarData?.dismiss()
}

@OptIn(ExperimentalMaterialApi::class)
fun BottomSheetScaffoldState.performAction() {
    snackbarHostState.currentSnackbarData?.performAction()
}


@OptIn(ExperimentalMaterialApi::class)
suspend fun ModalBottomSheetState.toggle() {
    if (isVisible) hide() else show()
}


