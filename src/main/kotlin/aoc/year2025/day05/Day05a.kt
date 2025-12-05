package aoc.year2025.day05

import aoc.common.expecting
import aoc.year2025.Input

object Day05a {

    fun parseIds(lines: List<String>): List<Long> {
        return lines
            .dropWhile { it.isNotEmpty() }
            .drop(1)
            .map { it.toLong() }
    }

    val input = Input.day05
    val ranges = parseRanges(input)
    val ids = parseIds(input)

    val result = ids.count { id ->
        ranges.any { it.contains(id) }
    }
}

fun main() {
    println(Day05a.result.expecting(652))
}
