package aoc.year2025

object Input {

    val day01 get() = readLines("Day01.txt")
    val day02 get() = readLines("Day02.txt")
    val day03 get() = readLines("Day03.txt")
    val day04 get() = readLines("Day04.txt")
    val day05 get() = readLines("Day05.txt")
    val day06 get() = readLines("Day06.txt")

    private fun readLines(filename: String): List<String> {
        return javaClass.getResourceAsStream("/aoc/year2025/$filename")!!.bufferedReader().use {
            it.readLines()
        }
    }
}
