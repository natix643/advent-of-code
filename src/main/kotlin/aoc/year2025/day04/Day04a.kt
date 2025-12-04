package aoc.year2025.day04

import aoc.common.Matrix
import aoc.common.expecting
import aoc.year2025.Input

object Day04a {
    val matrix = Matrix.parse(Input.day04)
    val result = findAccessibleRolls(matrix).size
}

fun main() {
    println(Day04a.result.expecting(1493))
}
