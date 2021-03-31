package com.funkymuse.composed

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.saveable.LocalSaveableStateRegistry
import androidx.compose.runtime.tooling.LocalInspectionTables
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.*

/**
 * Created by FunkyMuse, date 3/31/21
 */

@Composable
fun lifecycleOwner() = LocalLifecycleOwner.current

@Composable
fun context() = LocalContext.current

@Composable
fun configuration() = LocalConfiguration.current

@Composable
fun localView() = LocalView.current

@ExperimentalComposeUiApi
@Composable
fun autoFill() = LocalAutofill.current

@ExperimentalComposeUiApi
@Composable
fun autoFillTree() = LocalAutofillTree.current

@Composable
fun clipboardManager() = LocalClipboardManager.current

@Composable
fun density() = LocalDensity.current

@Composable
fun focusManager() = LocalFocusManager.current

@Composable
fun fontLoader() = LocalFontLoader.current

@Composable
fun hapticFeedback() = LocalHapticFeedback.current

@Composable
fun inspectionMode() = LocalInspectionMode.current

@Composable
fun layoutDirection() = LocalLayoutDirection.current

@Composable
fun savedStateRegistryOwner() = LocalSavedStateRegistryOwner.current

@Composable
fun textInputService() = LocalTextInputService.current

@Composable
fun uriHandler() = LocalUriHandler.current

@Composable
fun textToolbar() = LocalTextToolbar.current

@Composable
fun viewConfiguration() = LocalViewConfiguration.current

@Composable
fun windowInfo() = LocalWindowInfo.current

@Composable
fun absoluteElevation() = LocalAbsoluteElevation.current

@Composable
fun elevationOverlay() = LocalElevationOverlay.current

@Composable
fun contentAlpha() = LocalContentAlpha.current

@Composable
fun contentColor() = LocalContentColor.current

@Composable
fun textStyle() = LocalTextStyle.current

@Composable
fun textSelectionColors() = LocalTextSelectionColors.current

@Composable
fun indication() = LocalIndication.current

@InternalComposeApi
@Composable
fun inspectionTables() = LocalInspectionTables.current

@Composable
fun rippleTheme() = LocalRippleTheme.current

@Composable
fun saveableStateRegistry() = LocalSaveableStateRegistry.current


