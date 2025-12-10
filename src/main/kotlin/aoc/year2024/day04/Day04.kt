package aoc.year2024.day04

val example = """
    MMMSXXMASM
    MSAMXMSMSA
    AMXSXMAAMM
    MSAMASMSMX
    XMASAMXAMM
    XXAMMXXAMA
    SMSMSASXSS
    SAXAMASAAA
    MAMMMXMMMM
    MXMXAXMASX
""".trimIndent().lines()

typealias Matrix = List<List<Char>>

fun List<String>.toMatrix(): Matrix = map {
    it.toCharArray().toList()
}
