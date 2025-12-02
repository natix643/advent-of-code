package aoc.year2025.day02

import aoc.common.expecting
import aoc.year2025.Input

object Day02a {

    fun isInvalid(id: Long): Boolean {
        val string = id.toString()
        val left = string.substring(0..<string.length / 2)
        val right = string.substring(string.length / 2)
        return left == right
    }

    val input = Input.day02.first()
    val ranges = parseRanges(input)

    val invalidIds = ranges.flatMap { range ->
        range.filter { id -> isInvalid(id) }
    }
    val result = invalidIds.sum()
}

fun main() {
    println(Day02a.result.expecting(18952700150))
}
