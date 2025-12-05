package aoc.year2025.day05

val example = """
    3-5
    10-14
    16-20
    12-18

    1
    5
    8
    11
    17
    32
""".trimIndent().lines()

fun parseRanges(lines: List<String>): List<LongRange> {
    return lines.takeWhile {
        it.isNotEmpty()
    }.map { line ->
        val (lo, hi) = line.split('-').map { it.toLong() }
        lo..hi
    }
}
