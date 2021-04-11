package com.funkymuse.composed.core.utils

/**
 * Created by funkymuse on 4/11/21 to long live and prosper !
 */

internal fun generateRandomIntegerList(size: Int): MutableList<Int> {
    val resultList = ArrayList<Int>(size)
    for (i in 1..size) {
        resultList.add(kotlin.random.Random.nextInt(0, size))
    }
    return resultList
}