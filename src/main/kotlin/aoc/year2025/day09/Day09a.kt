package aoc.year2025.day09

import aoc.common.Point
import aoc.common.expecting
import aoc.year2025.Input
import kotlin.math.absoluteValue

typealias PointPair = Pair<Point, Point>

object Day09a {

    fun generatePairs(points: List<Point>): List<PointPair> {
        val result = mutableListOf<PointPair>()
        for (i in 0..<points.size) {
            for (j in (i + 1)..<points.size) {
                result += points[i] to points[j]
            }
        }
        return result
    }

    val points = parsePoints(Input.day09)

    val pairs = generatePairs(points)
    val areas = pairs.map { (a, b) ->
        ((a.x - b.x).absoluteValue.toLong() + 1) *
            ((a.y - b.y).absoluteValue.toLong() + 1)
    }
    val result = areas.max()
}

fun main() {
    println(Day09a.result.expecting(4761736832))
}
