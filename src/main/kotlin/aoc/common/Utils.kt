package aoc.common

const val CLEAR_SCREEN = "\u001b[H\u001b[2J"

fun <T> T.expecting(expected: Any): T {
    if (this != expected) {
        throw IllegalStateException("expected value to be $expected, but was $this")
    }
    return this
}

fun Iterable<Int>.product(): Int = fold(1) { acc, i -> acc * i }

fun Iterable<Long>.product(): Long = fold(1) { acc, i -> acc * i }
