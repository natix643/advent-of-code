package aoc.year2025.day01

import aoc.common.expecting
import aoc.year2025.Input

object Day01a {

    private fun countZeros(lines: List<String>): Int {
        var zeros = 0
        var position = 50

        for (line in lines) {
            val direction = line.first().toString()
            val distance = line.drop(1).toInt()

            when (direction) {
                "L" -> {
                    position = (position - distance) % 100
                    if (position < 0) {
                        position += 100
                    }
                }

                "R" -> {
                    position = (position + distance) % 100
                }
            }

            if (position == 0) {
                zeros++
            }
            println("$line -> $position")
        }

        return zeros
    }

    val result = countZeros(Input.day01)
}

fun main() {
    println(Day01a.result.expecting(1092))
}
