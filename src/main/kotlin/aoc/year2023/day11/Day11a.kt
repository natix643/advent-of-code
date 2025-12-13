package aoc.year2023.day11

import aoc.common.expecting
import aoc.year2023.Input

object Day11a : Day11() {

    val lines = Input.day11()

    val emptyRows = parseEmptyRows(lines)
    val emptyColumns = findEmptyColumns(lines)
    val galaxies = parseGalaxies(lines)
    val galaxyPairs = combinePairs(galaxies)

    val result = galaxyPairs.sumOf { (from, to) ->
        distance(
            from = from,
            to = to,
            emptyRows = emptyRows,
            emptyColumns = emptyColumns,
            expansion = 2
        )
    }
}

fun main() {
    println(Day11a.result.expecting(9805264L))
}
