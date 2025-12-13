package aoc.year2023.day06

import aoc.common.expecting
import aoc.common.product
import aoc.year2023.Input

object Day06a : Day06() {

    fun parseLine(line: String): List<Long> =
        line.split(":")[1].trim().split(Regex("\\s+")).map { it.toLong() }

    val lines = Input.day06()
    val times = parseLine(lines[0])
    val recordDistances = parseLine(lines[1])
    val races = times.zip(recordDistances).map { Race(it.first, it.second) }

    val result = races
        .map { countWinningTimes(it) }
        .product()
}

fun main() {
    println(Day06a.result.expecting(840336))
}
