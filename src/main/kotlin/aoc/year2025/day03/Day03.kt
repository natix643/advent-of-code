package aoc.year2025.day03

val example = """
    987654321111111
    811111111111119
    234234234234278
    818181911112111
""".trimIndent().lines()

fun parseBank(line: String): List<Int> {
    return line.toCharArray().map { it.digitToInt() }
}
