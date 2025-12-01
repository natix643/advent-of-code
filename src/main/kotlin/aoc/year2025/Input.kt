package aoc.year2025

object Input {

    val day01 get() = readLines("Day01.txt")

    private fun readLines(filename: String): List<String> {
        return javaClass.getResourceAsStream("/aoc/year2025/$filename")!!.bufferedReader().use {
            it.readLines()
        }
    }
}
