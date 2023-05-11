package com.funkymuse.composed.navigation.destination.arguments

data class DestinationValue(override val name: String, val value: String?, override val isNullable: Boolean) :
    DestinationBlock {

    init {
        if (value == null && !isNullable) {
            throw IllegalArgumentException("argument $name stated as not nullable can not be NULL, either pass true as isNullable or double check your logic")
        }
    }

    val destinationValue = if (isNullable) "${name}=${value}" else value.toString()
}

fun String.asNonNullDestinationValue(): DestinationValue = DestinationValue("", this, isNullable = false)
fun String.asNullWithDestinationValue(value: String?): DestinationValue = DestinationValue(this, value, isNullable = true)
fun String.asNullDestinationValue(): DestinationValue = DestinationValue(this, null, isNullable = true)