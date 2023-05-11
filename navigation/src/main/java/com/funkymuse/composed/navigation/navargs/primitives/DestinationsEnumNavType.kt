package com.funkymuse.composed.navigation.navargs.primitives

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.funkymuse.composed.navigation.navargs.DECODED_NULL
import com.funkymuse.composed.navigation.navargs.DestinationsNavType
import com.funkymuse.composed.navigation.navargs.ENCODED_NULL
import com.funkymuse.composed.navigation.navargs.valueOfIgnoreCase
/**
 * Source https://github.com/raamcosta/compose-destinations
 *
 **/
@Suppress("UNCHECKED_CAST")
class DestinationsEnumNavType<E : Enum<*>>(
    private val enumType: Class<E>,
) : DestinationsNavType<E?>() {

    override fun put(bundle: Bundle, key: String, value: E?) {
        bundle.putSerializable(key, value)
    }

    override fun get(bundle: Bundle, key: String): E? =
        @Suppress("DEPRECATION")
        bundle.getSerializable(key) as E?

    override fun parseValue(value: String): E? {
        if (value == DECODED_NULL) return null

        return enumType.valueOfIgnoreCase(value)
    }

    override fun serializeValue(value: E?): String =
        value?.name ?: ENCODED_NULL

    override fun get(savedStateHandle: SavedStateHandle, key: String): E? =
        savedStateHandle[key]
}
