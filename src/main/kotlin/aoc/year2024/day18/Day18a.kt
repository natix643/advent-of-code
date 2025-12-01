package aoc.year2024.day18

import aoc.common.Matrix
import aoc.common.Point
import aoc.common.expecting
import aoc.year2024.Input
import kotlin.time.measureTimedValue

object Day18a {

    fun printMatrixWithPath(matrix: Matrix<Tile>, path: List<Point>) {
        val formatted = matrix.format { point, item ->
            if (point in path) Tile.PATH.char else item.char
        }
        println(formatted)
    }

    val input = Input.day18
    val maxCorruptedPoints = inputSize

    val points = parsePoints(input)
    val target = maxCoords(points)

    val matrix = emptyMatrix(target).apply {
        corrupt(this, points.take(maxCorruptedPoints))
    }

    val timedPath = measureTimedValue {
        findShortestPath(matrix, target)
    }
    val path = timedPath.value!!
    val duration = timedPath.duration

    init {
        if (Visualisation.enabled) {
            printMatrixWithPath(matrix, path)
        }
    }

    val result = path.size - 1
}

fun main() {
    println(Day18a.result.expecting(360))
    println("Duration: ${Day18a.duration}")
}
