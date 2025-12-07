package aoc.common

open class InputReader {

    protected fun readLines(filename: String): List<String> {
        return javaClass.getResourceAsStream(filename)!!.bufferedReader().use {
            it.readLines()
        }
    }
}
