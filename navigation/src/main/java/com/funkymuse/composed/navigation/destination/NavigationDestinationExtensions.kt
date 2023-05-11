package com.funkymuse.composed.navigation.destination

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
context (NavigationDestination)
fun addStringArgument(any: String?): String = DestinationsStringNavType.serializeValue(any)

context (NavigationDestination)
fun addBooleanArgument(any: Boolean?): String = DestinationsBooleanNavType.serializeValue(any)

context (NavigationDestination)
fun addIntArgument(any: Int?): String = DestinationsIntNavType.serializeValue(any)

context (NavigationDestination)
fun addLongArgument(any: Long?): String = DestinationsLongNavType.serializeValue(any)

context (NavigationDestination)
fun addFloatArgument(any: Float?): String = DestinationsFloatNavType.serializeValue(any)

context (NavigationDestination)
fun addFileArgument(any: File?): String = DestinationsFileNavType.serializeValue(any)

context (NavigationDestination)
fun addUriArgument(any: Uri?): String = DestinationsUriNavType.serializeValue(any)

context (NavigationDestination)
inline fun <reified T : Enum<T>> addEnumArgument(any: T?): String = DestinationsEnumNavType(T::class.java).serializeValue(any)

context (NavigationDestination)
inline fun <reified T : Parcelable> addParcelableArgument(any: T): String =
    DefaultParcelableNavTypeSerializer(T::class.java).toRouteString(any)

//array
context (NavigationDestination)
fun addBooleanArrayArgument(any: BooleanArray?): String = DestinationsBooleanArrayNavType.serializeValue(any)

context (NavigationDestination)
fun addIntArrayArgument(any: IntArray?): String = DestinationsIntArrayNavType.serializeValue(any)

context (NavigationDestination)
fun addFloatArrayArgument(any: FloatArray?): String = DestinationsFloatArrayNavType.serializeValue(any)

context (NavigationDestination)
fun addLongArrayArgument(any: LongArray?): String = DestinationsLongArrayNavType.serializeValue(any)

context (NavigationDestination)
fun addStringArrayArgument(any: Array<String>?): String = DestinationsStringArrayNavType.serializeValue(any)

//serializable
context (NavigationDestination)
fun addSerializable(any: Serializable): String = DefaultSerializableNavTypeSerializer.toRouteString(any)

//arraylist
context (NavigationDestination)
fun addBooleanArrayListArgument(any: ArrayList<Boolean>?): String = DestinationsBooleanArrayListNavType.serializeValue(any)

context (NavigationDestination)
fun addFloatArrayListArgument(any: ArrayList<Float>?): String = DestinationsFloatArrayListNavType.serializeValue(any)

context (NavigationDestination)
fun addIntArrayListArgument(any: ArrayList<Int>?): String = DestinationsIntArrayListNavType.serializeValue(any)

context (NavigationDestination)
fun addLongArrayListArgument(any: ArrayList<Long>?): String = DestinationsLongArrayListNavType.serializeValue(any)

context (NavigationDestination)
fun addStringArrayListArgument(any: ArrayList<String>?): String = DestinationsStringArrayListNavType.serializeValue(any)

context (NavigationDestination)
inline fun <reified T : Enum<T>> addEnumArrayListArgument(any: ArrayList<T>?): String =
    DestinationsEnumArrayListNavType(T::class.java).serializeValue(any)
