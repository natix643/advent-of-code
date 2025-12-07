package aoc.year2025.day07

import aoc.common.Matrix
import aoc.common.Point
import aoc.common.expecting
import aoc.year2025.Input
import aoc.year2025.day07.Tile.BEAM
import aoc.year2025.day07.Tile.SPACE
import aoc.year2025.day07.Tile.SPLITTER
import aoc.year2025.day07.Tile.START

object Day07b {

    fun simulateBeams(matrix: Matrix<Tile>): Long {
        var totalCount = 0L

        val start = matrix.find(START)!!
        val beamHeads = mutableMapOf(matrix.bellow(start)!! to 1L)

        while (beamHeads.isNotEmpty()) {
            val (point, count) = beamHeads.entries.first()
            beamHeads.remove(point)
            matrix[point] = BEAM
            // println(matrix.format())

            val bellow = matrix.bellow(point)
            if (bellow != null) {
                val nextPoints = when (matrix[bellow]) {
                    SPACE -> listOf(bellow)
                    SPLITTER -> listOfNotNull(matrix.leftOf(bellow), matrix.rightOf(bellow))
                    else -> throw IllegalArgumentException()
                }
                nextPoints.forEach {
                    beamHeads.merge(it, count) { old, new -> old + new }
                }
            } else {
                totalCount += count
            }
        }
        return totalCount
    }

    val matrix = parseMatrix(Input.day07)
    val result = simulateBeams(matrix)
}

fun main() {
    println(Day07b.result.expecting(422102272495018))
}
