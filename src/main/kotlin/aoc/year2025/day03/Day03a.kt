package aoc.year2025.day03

import aoc.common.expecting
import aoc.year2025.Input

object Day03a {

    fun findJoltage(bank: List<Int>): Int {
        val first = bank.subList(0, bank.size - 1).max()
        val firstIndex = bank.indexOf(first)
        val second = bank.subList(firstIndex + 1, bank.size).max()
        return "${first}${second}".toInt()
    }

    val banks = Input.day03.map { parseBank(it) }

    val result = banks.sumOf { findJoltage(it) }
}

fun main() {
    println(Day03a.result.expecting(17196))
}
