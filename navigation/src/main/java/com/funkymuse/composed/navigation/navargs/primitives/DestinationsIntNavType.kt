package com.funkymuse.composed.navigation.navargs.primitives

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.funkymuse.composed.navigation.navargs.DECODED_NULL
import com.funkymuse.composed.navigation.navargs.DestinationsNavType
import com.funkymuse.composed.navigation.navargs.ENCODED_NULL
/**
 * Source https://github.com/raamcosta/compose-destinations
 *
 **/
object DestinationsIntNavType : DestinationsNavType<Int?>() {

    override fun put(bundle: Bundle, key: String, value: Int?) {
        if (value == null) {
            bundle.putByte(key, 0)
        } else {
            bundle.putInt(key, value)
        }
    }

    override fun get(bundle: Bundle, key: String): Int? =
        @Suppress("DEPRECATION")
        (intValue(bundle[key]))

    override fun parseValue(value: String): Int? =
        if (value == DECODED_NULL) {
            null
        } else {
            IntType.parseValue(value)
        }

    override fun serializeValue(value: Int?): String =
        value?.toString() ?: ENCODED_NULL

    override fun get(savedStateHandle: SavedStateHandle, key: String): Int? =
        intValue(savedStateHandle[key])

    private fun intValue(valueForKey: Any?): Int? =
        if (valueForKey is Int) {
            valueForKey
        } else {
            null
        }
}
