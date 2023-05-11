package com.funkymuse.composedlib.navigation.destinations.dialogs.test2

import androidx.navigation.NavHostController
import com.funkymuse.composed.core.stability_wrappers.StableHolder
import com.funkymuse.composed.navigation.arguments.previous_destination.AddArgumentsToPreviousDestination

class ArgumentsFromTest2Dialog(override val navHostController: StableHolder<NavHostController>) : AddArgumentsToPreviousDestination {

    companion object {
        const val TEXT = "text"
    }

    fun addText(text :String){
        set(TEXT, text)
    }
    override fun consumeArgumentsAtReceivingDestination() {
        consumeArgument(TEXT)
    }
}