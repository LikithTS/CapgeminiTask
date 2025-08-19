package com.likith.capgeminitask.presentation.util

/**
 * This extension function is written based on task example
 * AAAA-BB-CC-12
 */
fun String.toValidSwiftCode(): String {
    val r = this.take(10) // 4 + 2 + 2 + 2
    val b = StringBuilder(r.length + 3)
    for (i in r.indices) {
        b.append(r[i])
        if ((i == 3 || i == 5 || i == 7) && i != r.lastIndex) b.append('-')
    }
    return b.toString()

}