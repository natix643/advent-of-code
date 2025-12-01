package aoc.year2025.day01

import aoc.common.expecting
import aoc.year2025.Input

object Day01b {

    private fun countZeros(lines: List<String>): Int {
        var zeros = 0
        var position = 50

        for (line in lines) {
            val direction = line.first().toString()
            val distance = line.drop(1).toInt()

            val fullRotations = distance / 100
            val remainingDistance = distance % 100

            repeat(remainingDistance) {
                when (direction) {
                    "L" -> {
                        position--
                        if (position < 0) {
                            position += 100
                        }
                    }

                    "R" -> {
                        position++
                        if (position >= 100) {
                            position -= 100
                        }
                    }
                }

                if (position == 0) {
                    zeros++
                }
            }

            zeros += fullRotations
            println("$line -> $position ($zeros zeros)")
        }

        return zeros
    }

    val result = countZeros(Input.day01)
}

fun main() {
    println(Day01b.result.expecting(6616))
}
