package aoc.year2025.day06

import aoc.common.expecting
import aoc.common.product
import aoc.year2025.Input

object Day06b {

    data class Expression(
        val operator: String,
        val operands: List<Long>
    ) {
        fun eval(): Long = when (operator) {
            "+" -> operands.sum()
            "*" -> operands.product()
            else -> throw IllegalArgumentException(operator)
        }
    }

    fun parseExpression(block: List<String>): Expression {
        val operandLines = block.dropLast(1)
        val width = operandLines.first().length

        val operands = (0..<width).map { position ->
            val digits = operandLines
                .map { it[position] }
                .filter { !it.isWhitespace() }
            digits.joinToString("").toLong()
        }

        return Expression(
            operands = operands,
            operator = block.last().trim()
        )
    }

    fun splitToBlocks(input: List<String>): List<List<String>> {
        val result = mutableListOf<List<String>>()

        val lastLine = input.last()
        var toIndex = lastLine.indices.last

        for (i in lastLine.indices.reversed()) {
            if (lastLine[i] != ' ') {
                val fromIndex = i
                val block = input.map { it.substring(fromIndex..toIndex) }
                result.add(block)

                toIndex = i - 2
            }
        }
        return result
    }

    val blocks = splitToBlocks(Input.day06)
    val expressions = blocks.map { parseExpression(it) }

    val result = expressions.sumOf { it.eval() }

}

fun main() {
    println(Day06b.result.expecting(8843673199391))
}
