package com.funkymuse.composed.navigation.arguments.nav_entry

import android.net.Uri
import android.os.Parcelable
import com.funkymuse.composed.navigation.navargs.helpers.DestinationsFileNavType
import com.funkymuse.composed.navigation.navargs.helpers.DestinationsUriNavType
import com.funkymuse.composed.navigation.navargs.parcelable.DefaultParcelableNavTypeSerializer
import com.funkymuse.composed.navigation.navargs.primitives.DestinationsBooleanNavType
import com.funkymuse.composed.navigation.navargs.primitives.DestinationsEnumNavType
import com.funkymuse.composed.navigation.navargs.primitives.DestinationsFloatNavType
import com.funkymuse.composed.navigation.navargs.primitives.DestinationsIntNavType
import com.funkymuse.composed.navigation.navargs.primitives.DestinationsLongNavType
import com.funkymuse.composed.navigation.navargs.primitives.DestinationsStringNavType
import com.funkymuse.composed.navigation.navargs.primitives.array.DestinationsBooleanArrayNavType
import com.funkymuse.composed.navigation.navargs.primitives.array.DestinationsFloatArrayNavType
import com.funkymuse.composed.navigation.navargs.primitives.array.DestinationsIntArrayNavType
import com.funkymuse.composed.navigation.navargs.primitives.array.DestinationsLongArrayNavType
import com.funkymuse.composed.navigation.navargs.primitives.array.DestinationsStringArrayNavType
import com.funkymuse.composed.navigation.navargs.primitives.arraylist.DestinationsBooleanArrayListNavType
import com.funkymuse.composed.navigation.navargs.primitives.arraylist.DestinationsEnumArrayListNavType
import com.funkymuse.composed.navigation.navargs.primitives.arraylist.DestinationsFloatArrayListNavType
import com.funkymuse.composed.navigation.navargs.primitives.arraylist.DestinationsIntArrayListNavType
import com.funkymuse.composed.navigation.navargs.primitives.arraylist.DestinationsLongArrayListNavType
import com.funkymuse.composed.navigation.navargs.primitives.arraylist.DestinationsStringArrayListNavType
import com.funkymuse.composed.navigation.navargs.serializable.DefaultSerializableNavTypeSerializer
import java.io.File
import java.io.Serializable

//primitives
context (NavigationEntryArguments)
fun getStringArgument(key: String): String? = DestinationsStringNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
fun getBooleanArgument(key: String, defaultValue: Boolean): Boolean? = DestinationsBooleanNavType.safeGet(arguments)

context (NavigationEntryArguments)
fun getIntArgument(key: String): Int? = DestinationsIntNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
fun getLongArgument(key: String): Long? = DestinationsLongNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
fun getFloatArgument(key: String): Float? = DestinationsFloatNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
fun getFileArgument(key: String): File? = DestinationsFileNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
fun getUriArgument(key: String): Uri? = DestinationsUriNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
inline fun <reified T : Enum<T>> getEnumArgument(key: String): T? =
    DestinationsEnumNavType(T::class.java).safeGet(arguments, key)

context (NavigationEntryArguments)
inline fun <reified T : Parcelable> getParcelableArgument(key: String): T =
    DefaultParcelableNavTypeSerializer(T::class.java).fromRouteString(
        arguments?.getString(key)
            ?: throw IllegalArgumentException("getParcelableArgument for $key is null"),
    ) as T

//array
context (NavigationEntryArguments)
fun getBooleanArrayArgument(key: String): BooleanArray? =
    DestinationsBooleanArrayNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
fun getIntArrayArgument(key: String): IntArray? =
    DestinationsIntArrayNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
fun getFloatArrayArgument(key: String): FloatArray? =
    DestinationsFloatArrayNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
fun getLongArrayArgument(key: String): LongArray? =
    DestinationsLongArrayNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
fun getStringArrayArgument(key: String): Array<String>? =
    DestinationsStringArrayNavType.safeGet(arguments, key)

//serializable
context (NavigationEntryArguments)
fun getSerializable(key: String): Serializable =
    DefaultSerializableNavTypeSerializer.fromRouteString(
        arguments?.getString(key) ?: throw IllegalArgumentException("getSerializable for $key is null"),
    )

//arraylist
context (NavigationEntryArguments)
fun getBooleanArrayListArgument(key: String): ArrayList<Boolean>? =
    DestinationsBooleanArrayListNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
fun getFloatArrayListArgument(key: String): ArrayList<Float>? =
    DestinationsFloatArrayListNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
fun getIntArrayListArgument(key: String): ArrayList<Int>? =
    DestinationsIntArrayListNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
fun getLongArrayListArgument(key: String): ArrayList<Long>? =
    DestinationsLongArrayListNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
fun getStringArrayListArgument(key: String): ArrayList<String>? =
    DestinationsStringArrayListNavType.safeGet(arguments, key)

context (NavigationEntryArguments)
inline fun <reified T : Enum<T>> getEnumArrayListArgument(key: String): ArrayList<T>? =
    DestinationsEnumArrayListNavType(T::class.java).safeGet(arguments, key)
