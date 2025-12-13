package aoc.year2023.day06

import aoc.common.expecting
import aoc.year2023.Input

object Day06b : Day06() {

    fun parseLine(line: String): Long =
        line.split(":")[1].trim().replace(" ", "").toLong()

    val lines = Input.day06()
    val time = parseLine(lines[0])
    val recordDistance = parseLine(lines[1])
    val race = Race(time, recordDistance)

    val result = countWinningTimes(race)
}

fun main() {
    println(Day06b.result.expecting(41382569))
}
