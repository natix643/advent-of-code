package aoc.year2025.day08

import kotlin.math.pow
import kotlin.math.sqrt

val example = """
    162,817,812
    57,618,57
    906,360,560
    592,479,940
    352,342,300
    466,668,158
    542,29,236
    431,825,988
    739,650,466
    52,470,668
    216,146,977
    819,987,18
    117,168,530
    805,96,715
    346,949,466
    970,615,88
    941,993,340
    862,61,35
    984,92,344
    425,690,689
""".trimIndent().lines()

typealias Graph = Set<Node>

data class Node(
    val x: Long,
    val y: Long,
    val z: Long,
) {
    override fun toString() = "($x,$y,$z)"
}

data class Edge(
    val from: Node,
    val to: Node,
    val length: Double = sqrt(
        (from.x - to.x).toDouble().pow(2) +
            (from.y - to.y).toDouble().pow(2) +
            (from.z - to.z).toDouble().pow(2)
    )
)

fun parseNodes(lines: List<String>): List<Node> {
    return lines.map { line ->
        val (x, y, z) = line.split(',').map { it.toLong() }
        Node(x, y, z)
    }
}

fun generateEdges(nodes: List<Node>, maxCount: Int): List<Edge> {
    val result = mutableListOf<Edge>()
    for (i in 0..<nodes.size) {
        for (j in (i + 1)..<nodes.size) {
            result += Edge(nodes[i], nodes[j])
        }
    }
    return result.sortedBy { it.length }.take(maxCount)
}
