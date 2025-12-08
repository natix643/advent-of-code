package aoc.year2025.day08

import aoc.common.expecting
import aoc.year2025.Input

object Day08b {

    fun connectGraphs(nodes: List<Node>, edges: List<Edge>): Pair<Node, Node> {
        val graphsByNodes = mutableMapOf<Node, Graph>()

        for (node in nodes) {
            graphsByNodes[node] = setOf(node)
        }

        var graphCount = nodes.size

        for (edge in edges) {
            val graph1 = graphsByNodes.getValue(edge.from)
            val graph2 = graphsByNodes.getValue(edge.to)
            if (graph1 != graph2) {
                val union = graph1 + graph2
                for (node in union) {
                    graphsByNodes[node] = union
                }

                graphCount--
                if (graphCount == 1) {
                    return Pair(edge.from, edge.to)
                }
            }
        }
        throw IllegalStateException("finished with graph count $graphCount")
    }

    val nodes = parseNodes(Input.day08)
    val edges = generateEdges(nodes, Int.MAX_VALUE)
    val lastConnection = connectGraphs(nodes, edges)

    val result = lastConnection.let { (from, to) -> from.x * to.x }
}

fun main() {
    println(Day08b.result.expecting(4639477L))
}
