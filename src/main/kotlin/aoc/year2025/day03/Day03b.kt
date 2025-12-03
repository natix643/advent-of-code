package aoc.year2025.day03

import aoc.common.expecting
import aoc.year2025.Input

object Day03b {

    fun findJoltage(bank: List<Int>): Long {
        val result = StringBuilder()
        var lo = 0
        var hi = bank.size - 12

        repeat(12) {
            val window = bank.subList(lo, hi + 1)
            val next = window.max()
            result.append(next)

            lo += window.indexOf(next) + 1
            hi++
        }
        return result.toString().toLong()
    }

    val banks = Input.day03.map { parseBank(it) }

    val result = banks.sumOf {
        findJoltage(it)
    }
}

fun main() {
    println(Day03b.result.expecting(171039099596062))
}
