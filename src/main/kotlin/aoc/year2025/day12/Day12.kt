package aoc.year2025.day12

import aoc.common.expecting
import aoc.common.product
import aoc.year2025.Input

object Day12 {

    val example = """
        0:
        ###
        ##.
        ##.

        1:
        ###
        ##.
        .##

        2:
        .##
        ###
        ##.

        3:
        ##.
        ###
        ##.

        4:
        ###
        #..
        ###

        5:
        ###
        .#.
        ###

        4x4: 0 0 0 0 2 0
        12x5: 1 0 1 0 2 2
        12x5: 1 0 1 0 3 2
    """.trimIndent()

    val input = Input.day12.joinToString("\n")
    val regions = input.split("\n\n").last().lines()

    val result = regions.count { line ->
        val parts = line.split(": ")
        val area = parts[0].split("x").map { it.toInt() }.product()
        val quantities = parts[1].split(' ').map { it.toInt() }

        area >= quantities.sum() * 9
    }
}

fun main() {
    println(Day12.result.expecting(476))
}
