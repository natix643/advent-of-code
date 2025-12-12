package aoc.year2025.day11

import aoc.common.expecting
import aoc.year2025.Input

object Day11b {

    val example = """
        svr: aaa bbb
        aaa: fft
        fft: ccc
        bbb: tty
        tty: ccc
        ccc: ddd eee
        ddd: hub
        hub: fff
        eee: dac
        dac: fff
        fff: ggg hhh
        ggg: out
        hhh: out
    """.trimIndent().lines()

    fun countPaths(
        start: Device,
        target: Device,
        memo: MutableMap<String, Long> = hashMapOf()
    ): Long {
        return when (start.name) {
            target.name -> 1
            in memo -> memo.getValue(start.name)
            else -> {
                val outputSum = start.outputs.sumOf {
                    countPaths(it, target, memo)
                }
                memo[start.name] = outputSum
                outputSum
            }
        }
    }

    val devices = parseDevices(Input.day11)

    val svr = devices.getValue(DeviceName.SVR)
    val fft = devices.getValue(DeviceName.FFT)
    val dac = devices.getValue(DeviceName.DAC)
    val out = devices.getValue(DeviceName.OUT)

    val svr2fft = countPaths(svr, fft)
    val fft2dac = countPaths(fft, dac)
    val dac2out = countPaths(dac, out)

    val result = svr2fft * fft2dac * dac2out
}

fun main() {
    println(Day11b.result.expecting(506264456238938))
}
