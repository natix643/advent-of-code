package aoc.year2025.day04

import aoc.common.Matrix
import aoc.common.expecting
import aoc.year2025.Input

object Day04b {

    fun removeAccessibleRolls(matrix: Matrix<Char>): Int {
        var count = 0

        while (true) {
            val accessible = findAccessibleRolls(matrix)
            if (accessible.isEmpty()) {
                break
            }
            count += accessible.size

            for (roll in accessible) {
                matrix[roll] = Tile.EMPTY
            }
        }
        return count
    }

    val matrix = Matrix.parse(Input.day04)
    val result = removeAccessibleRolls(matrix)
}

fun main() {
    println(Day04b.result.expecting(9194))
}
