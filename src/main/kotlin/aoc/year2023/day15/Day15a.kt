package aoc.year2023.day15

import aoc.common.expecting
import aoc.year2023.Input

object Day15a : Day15() {

    val steps = Input.day15().first().split(',')

    val result = steps.sumOf {
        hash(it)
    }
}

fun main() {
    println(Day15a.result.expecting(517965))
}
