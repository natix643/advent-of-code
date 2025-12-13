package aoc.year2023.day05

import aoc.common.expecting
import aoc.year2023.Input

object Day05a : Day05() {

    fun getLocation(seed: Long): Long {
        var mapped = seed
        for (mapping in mappings) {
            mapped = mapping[mapped]
        }
        return mapped
    }

    val input = Input.day05().joinToString("\n")
    val seeds = parseSeeds(input)
    val mappings = parseMappings(input)

    val result = seeds.minOf { getLocation(it) }
}

fun main() {
    println(Day05a.result.expecting(88151870L))
}
