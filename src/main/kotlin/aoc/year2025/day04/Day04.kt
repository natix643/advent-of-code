package aoc.year2025.day04

import aoc.common.Matrix
import aoc.common.Point

val example = """
    ..@@.@@@@.
    @@@.@.@.@@
    @@@@@.@.@@
    @.@@@@..@.
    @@.@@@@.@@
    .@@@@@@@.@
    .@.@.@.@@@
    @.@@@.@@@@
    .@@@@@@@@.
    @.@.@@@.@.
""".trimIndent().lines()

object Tile {
    const val ROLL = '@'
    const val EMPTY = '.'
}

fun findAccessibleRolls(matrix: Matrix<Char>): List<Point> {
    return matrix.findAll { tile, point ->
        tile == Tile.ROLL
            && matrix.adjacentPoints(point).count { matrix[it] == Tile.ROLL } < 4
    }
}
