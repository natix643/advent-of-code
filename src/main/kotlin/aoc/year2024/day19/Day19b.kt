package aoc.year2024.day19

import aoc.common.expecting
import aoc.year2024.Input

object Day19b {

    fun countArrangements(design: String): Long {
        val memoized = memo[design]
        if (memoized != null) {
            return memoized
        }

        if (design == "") {
            return 0
        }

        val count = towels.sumOf { towel ->
            when {
                design == towel -> 1
                design.startsWith(towel) -> countArrangements(design.substring(towel.length))
                else -> 0
            }
        }

        memo[design] = count
        // println("design=$design, memo=$memo")
        return count
    }

    val input = Input.day19

    val towels = parseTowels(input)
    val designs = parseDesigns(input)
    val memo = mutableMapOf<String, Long>()

    val result = designs.sumOf {
        countArrangements(it)
    }
}

fun main() {
    println(Day19b.result.expecting(883443544805484))
}
