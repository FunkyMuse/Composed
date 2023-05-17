package com.funkymuse.composedlib.navigation.destinations.dialogs.red

import androidx.lifecycle.SavedStateHandle
import com.funkymuse.composed.navigation.arguments.viewmodel.ViewModelNavigationArguments
import com.funkymuse.composed.navigation.arguments.viewmodel.getStringArrayArgument
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class RedDialogViewModelArguments @Inject constructor(override val savedStateHandle: SavedStateHandle) : ViewModelNavigationArguments {

    val texts = getStringArrayArgument(RedDialogDestination.TEXTS)
}