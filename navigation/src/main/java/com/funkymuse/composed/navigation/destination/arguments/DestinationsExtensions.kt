package com.funkymuse.composed.navigation.destination.arguments


fun createDestination(route: String, vararg arguments: DestinationArgument): String =
    route
        .plus(
            arguments.toList().joinToStringInternal(
                separator = { index ->
                    arguments[index].separator
                },
                prefix = arguments.first().prefix,
                transform = { destinationArgument ->
                    destinationArgument.argument
                }
            )
        )

fun applyArgumentsToDestination(route: String, vararg arguments: DestinationValue): String =
    route
        .plus(
            arguments.toList().joinToStringInternal(
                separator = { index -> arguments[index].separator },
                prefix = arguments.first().prefix,
                transform = { destinationArgument ->
                    destinationArgument.destinationValue
                }
            )
        )

private fun <T> Iterable<T>.joinToStringInternal(
    separator: (Int) -> CharSequence,
    prefix: CharSequence = "",
    postfix: CharSequence = "",
    limit: Int = -1,
    truncated: CharSequence = "...",
    transform: ((T) -> CharSequence)? = null
): String =
    joinToInternal(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()


private fun <T, A : Appendable> Iterable<T>.joinToInternal(
    buffer: A,
    separator: (Int) -> CharSequence,
    prefix: CharSequence = "",
    postfix: CharSequence = "",
    limit: Int = -1,
    truncated: CharSequence = "...",
    transform: ((T) -> CharSequence)? = null
): A {
    buffer.append(prefix)
    var count = 0
    var index = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator(index))
        if (limit < 0 || count <= limit) {
            buffer.appendElementInternal(element, transform)
            index++
        } else break
    }
    if ((limit >= 0) && (count > limit)) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}


private fun <T> Appendable.appendElementInternal(element: T, transform: ((T) -> CharSequence)?) {
    when {
        transform != null -> append(transform(element))
        element is CharSequence? -> append(element)
        element is Char -> append(element)
        else -> append(element.toString())
    }
}