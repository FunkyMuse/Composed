package com.funkymuse.composed.navigation.navargs.primitives.arraylist

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.funkymuse.composed.navigation.navargs.DECODED_EMPTY_STRING
import com.funkymuse.composed.navigation.navargs.DECODED_NULL
import com.funkymuse.composed.navigation.navargs.DestinationsNavType
import com.funkymuse.composed.navigation.navargs.ENCODED_EMPTY_STRING
import com.funkymuse.composed.navigation.navargs.ENCODED_NULL
import com.funkymuse.composed.navigation.navargs.encodeForRoute
import com.funkymuse.composed.navigation.navargs.encodedComma
/**
 * Source https://github.com/raamcosta/compose-destinations
 *
 **/
object DestinationsStringArrayListNavType : DestinationsNavType<ArrayList<String>?>() {

    override fun put(bundle: Bundle, key: String, value: ArrayList<String>?) {
        bundle.putStringArrayList(key, value)
    }

    override fun get(bundle: Bundle, key: String): ArrayList<String>? =
        bundle.getStringArrayList(key)

    override fun parseValue(value: String): ArrayList<String>? =
        when (value) {
            DECODED_NULL -> null
            "[]" -> arrayListOf()
            else ->
                value
                    .subSequence(1, value.length - 1)
                    .split(encodedComma).mapTo(ArrayList()) {
                        when (it) {
                            DECODED_EMPTY_STRING -> ""
                            else -> it
                        }
                    }
        }

    override fun serializeValue(value: ArrayList<String>?): String =
        when (value) {
            null -> ENCODED_NULL
            else -> encodeForRoute(
                "[" + value.joinToString(encodedComma) {
                    it.ifEmpty { ENCODED_EMPTY_STRING }
                } + "]",
            )
        }

    override fun get(savedStateHandle: SavedStateHandle, key: String): ArrayList<String>? =
        savedStateHandle[key]
}
