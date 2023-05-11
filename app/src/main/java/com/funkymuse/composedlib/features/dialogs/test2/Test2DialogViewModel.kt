package com.funkymuse.composedlib.features.dialogs.test2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.funkymuse.composedlib.navigation.destinations.dialogs.test2.Test2DialogViewModelArguments
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class Test2DialogViewModel @Inject constructor(
    test2DialogViewModelArguments: Test2DialogViewModelArguments
) : ViewModel() {

    private val _texts = MutableStateFlow(test2DialogViewModelArguments.texts)
    val texts = _texts.asStateFlow()

}