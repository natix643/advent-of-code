package aoc.year2025.day02

import aoc.common.expecting
import aoc.year2025.Input

object Day02b {

    fun String.isRepetitionOf(that: String): Boolean {
        return when {
            this == that -> true
            this.length < that.length -> false
            else -> this.startsWith(that) && this.substring(that.length).isRepetitionOf(that)
        }
    }

    fun isInvalid(id: Long): Boolean {
        val string = id.toString()
        val pivots = (string.length / 2).downTo(1)

        return pivots.any { pivot ->
            val left = string.substring(0..<pivot)
            val right = string.substring(pivot)
            right.isRepetitionOf(left)
        }
    }

    val input = Input.day02.first()
    val ranges = parseRanges(input)

    val invalidIds = ranges.flatMap { range ->
        range.filter { id -> isInvalid(id) }
    }
    val result = invalidIds.sum()
}

fun main() {
    println(Day02b.result.expecting(28858486244))
}
