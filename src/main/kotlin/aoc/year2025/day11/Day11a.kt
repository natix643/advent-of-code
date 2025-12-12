package aoc.year2025.day11

import aoc.common.expecting
import aoc.year2025.Input
import java.util.ArrayDeque

object Day11a {

    val example = """
        aaa: you hhh
        you: bbb ccc
        bbb: ddd eee
        ccc: ddd eee fff
        ddd: ggg
        eee: out
        fff: out
        ggg: out
        hhh: ccc fff iii
        iii: out
    """.trimIndent().lines()

    fun countPaths(start: Device): Int {
        var count = 0

        val stack = ArrayDeque<Device>().apply {
            add(start)
        }

        while (stack.isNotEmpty()) {
            val device = stack.pop()
            if (device.name == DeviceName.OUT) {
                count++
            } else {
                device.outputs.forEach {
                    stack.push(it)
                }
            }
        }
        return count
    }

    val devices = parseDevices(Input.day11)
    val start = devices.getValue(DeviceName.YOU)

    val result = countPaths(start)
}

fun main() {
    println(Day11a.result.expecting(607))
}
