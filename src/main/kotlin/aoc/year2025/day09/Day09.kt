package aoc.year2025.day09

import aoc.common.Point

val example = """
    7,1
    11,1
    11,7
    9,7
    9,5
    2,5
    2,3
    7,3
""".trimIndent().lines()

fun parsePoints(input: List<String>): List<Point> {
    return input.map { line ->
        val (x, y) = line.split(',').map { it.toInt() }
        Point(x, y)
    }
}
