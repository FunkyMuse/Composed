package com.funkymuse.composedlib.features.dialogs.red

import androidx.lifecycle.ViewModel
import com.funkymuse.composedlib.navigation.destinations.dialogs.red.RedDialogViewModelArguments
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class RedDialogViewModel @Inject constructor(
    redDialogViewModelArguments: RedDialogViewModelArguments
) : ViewModel() {

    private val _texts = MutableStateFlow(redDialogViewModelArguments.texts)
    val texts = _texts.asStateFlow()

}