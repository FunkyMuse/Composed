package com.funkymuse.composed.navigation.destination.arguments

data class DestinationArgument(override val name: String, override val isNullable: Boolean = false) : DestinationBlock

fun String.asRequiredArgument() = DestinationArgument(this)
fun String.asOptionalArgument() = DestinationArgument(this, true)