package aoc.year2023.day03

import aoc.common.expecting
import aoc.year2023.Input

object Day03b : Day03() {

    val lines = Input.day03()
    val numbers = findNumbers(lines)
    val gears = findSymbols(lines).filter { it.value == "*" }

    val result = gears.map { gear ->
        numbers.filter { number -> areAdjacent(number, gear) }
    }.filter {
        it.size == 2
    }.sumOf {
        it[0].value.toInt() * it[1].value.toInt()
    }
}

fun main() {
    println(Day03b.result.expecting(81463996))
}
