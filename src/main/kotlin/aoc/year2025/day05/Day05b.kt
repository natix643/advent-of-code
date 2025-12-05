package aoc.year2025.day05

import aoc.common.expecting
import aoc.year2025.Input

object Day05b {

    fun LongRange.size(): Long = last - first + 1

    fun LongRange.combine(that: LongRange): LongRange? {
        return when {
            this == that -> this
            this.first <= that.first && this.last >= that.last -> this
            this.first >= that.first && this.last <= that.last -> that
            this.first <= that.first && this.last >= that.first && this.last <= that.last -> this.first..that.last
            this.first >= that.first && this.first <= that.last && this.last >= that.last -> that.first..this.last
            else -> null
        }
    }

    fun combineAll(ranges: List<LongRange>): Set<LongRange> {
        val result = mutableSetOf<LongRange>()

        for (range in ranges) {
            var candidate = range
            val existing = result.iterator()

            while (existing.hasNext()) {
                val combined = candidate.combine(existing.next())
                if (combined != null) {
                    existing.remove()
                    candidate = combined
                }
            }
            result.add(candidate)
        }
        return result
    }

    val input = Input.day05
    val ranges = parseRanges(input)

    val combinedRanges = combineAll(ranges)
    val result = combinedRanges.sumOf { it.size() }
}

fun main() {
    println(Day05b.result.expecting(341753674214273))
}
