package aoc.year2025.day06

import aoc.common.Matrix
import aoc.common.expecting
import aoc.year2025.Input

object Day06a {

    fun parseExpressions(lines: List<String>): List<List<String>> {
        val matrix = Matrix(items = lines.map {
            it.trim().split(Regex("\\s+")).toMutableList()
        })
        return matrix.columns()
    }

    fun eval(expression: List<String>): Long {
        val operands = expression.subList(0, expression.size - 1).map { it.toLong() }
        val operator = expression.last()
        return when (operator) {
            "+" -> operands.sum()
            "*" -> operands.reduce { a, b -> a * b }
            else -> throw IllegalArgumentException(operator)
        }
    }

    val expressions = parseExpressions(Input.day06)
    val result = expressions.sumOf { eval(it) }
}

fun main() {
    println(Day06a.result.expecting(5524274308182))
}
