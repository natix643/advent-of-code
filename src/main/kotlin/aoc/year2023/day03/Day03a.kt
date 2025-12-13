package aoc.year2023.day03

import aoc.common.expecting
import aoc.year2023.Input

object Day03a : Day03() {

    val lines = Input.day03()
    val numbers = findNumbers(lines)
    val symbols = findSymbols(lines)

    val result = numbers.filter { number ->
        symbols.any { symbol -> areAdjacent(number, symbol) }
    }.sumOf {
        it.value.toInt()
    }
}

fun main() {
    println(Day03a.result.expecting(527144))
}
