package com.funkymuse.composed.core

import android.content.Context
import android.content.res.Configuration
import android.view.View
import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.saveable.LocalSaveableStateRegistry
import androidx.compose.runtime.saveable.SaveableStateRegistry
import androidx.compose.runtime.tooling.CompositionData
import androidx.compose.runtime.tooling.LocalInspectionTables
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.autofill.Autofill
import androidx.compose.ui.autofill.AutofillTree
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.platform.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.input.TextInputService
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.LifecycleOwner
import androidx.savedstate.SavedStateRegistryOwner

/**
 * Created by FunkyMuse, date 3/31/21
 */

val lifecycleOwner : LifecycleOwner @Composable get() { return LocalLifecycleOwner.current }

val context : Context @Composable get() { return LocalContext.current }

val configuration : Configuration @Composable get() { return LocalConfiguration.current }

val view : View @Composable get() { return LocalView.current }

@ExperimentalComposeUiApi
val autoFill : Autofill? @Composable get() { return LocalAutofill.current }


@ExperimentalComposeUiApi
val autoFillTree : AutofillTree @Composable get() { return LocalAutofillTree.current }

val clipboardManager : ClipboardManager @Composable get() { return LocalClipboardManager.current }

val density : Density @Composable get() { return LocalDensity.current }

val focusManager : FocusManager @Composable get() { return LocalFocusManager.current }


val fontLoader:  Font.ResourceLoader @Composable get() {return  LocalFontLoader.current}

val hapticFeedback: HapticFeedback @Composable get() {return  LocalHapticFeedback.current}

val inspectionMode: Boolean  @Composable get() {return  LocalInspectionMode.current}

val layoutDirection: LayoutDirection @Composable get() {return  LocalLayoutDirection.current}

val savedStateRegistryOwner: SavedStateRegistryOwner @Composable get() {return  LocalSavedStateRegistryOwner.current}

val textInputService: TextInputService? @Composable get() {return  LocalTextInputService.current}

val uriHandler: UriHandler @Composable get() {return  LocalUriHandler.current}

val textToolbar: TextToolbar @Composable get() {return  LocalTextToolbar.current}

val viewConfiguration: ViewConfiguration @Composable get() {return  LocalViewConfiguration.current}

val windowInfo: WindowInfo @Composable get() {return  LocalWindowInfo.current}

val absoluteElevation:  Dp @Composable get() {return  LocalAbsoluteElevation.current}

val elevationOverlay: ElevationOverlay? @Composable get() {return  LocalElevationOverlay.current}

val contentAlpha: Float @Composable get() {return  LocalContentAlpha.current}

val contentColor : Color @Composable get() {return  LocalContentColor.current}

val textStyle: TextStyle @Composable get()  {return  LocalTextStyle.current}

val textSelectionColors:TextSelectionColors @Composable get()  {return  LocalTextSelectionColors.current}

val indication: Indication @Composable get()  {return  LocalIndication.current}

@InternalComposeApi
val inspectionTables:MutableSet<CompositionData>? @Composable get()  {return  LocalInspectionTables.current}

val rippleTheme: RippleTheme @Composable get()  {return  LocalRippleTheme.current}

val saveableStateRegistry: SaveableStateRegistry? @Composable get()  {return  LocalSaveableStateRegistry.current}

