package aoc.year2025.day07

import aoc.common.Matrix
import aoc.common.Point
import aoc.common.expecting
import aoc.year2025.Input
import aoc.year2025.day07.Tile.*

object Day07a {

    fun simulateBeams(matrix: Matrix<Tile>): Int {
        var splitCount = 0

        val start = matrix.find(START)!!
        val beamHeads = mutableSetOf<Point>()
        beamHeads.add(matrix.bellow(start)!!)

        while (beamHeads.isNotEmpty()) {
            val beamHead = beamHeads.first()
            beamHeads.remove(beamHead)
            matrix[beamHead] = BEAM

            val nextPoint = matrix.bellow(beamHead)
            if (nextPoint != null) {
                when (matrix[nextPoint]) {
                    SPACE -> beamHeads.add(nextPoint)
                    SPLITTER -> {
                        splitCount++
                        beamHeads.addAll(listOfNotNull(matrix.leftOf(nextPoint), matrix.rightOf(nextPoint)))
                    }

                    else -> {}
                }
            }
            // println(matrix.format())
        }
        return splitCount
    }

    val matrix = parseMatrix(Input.day07)
    val result = simulateBeams(matrix)
}

fun main() {
    println(Day07a.result.expecting(1681))
}
