package aoc.year2025.day08

import aoc.common.expecting
import aoc.year2025.Input

object Day08a {

    fun connectGraphs(nodes: List<Node>, edges: List<Edge>): List<Graph> {
        val graphsByNodes = mutableMapOf<Node, Graph>()

        for (node in nodes) {
            graphsByNodes[node] = setOf(node)
        }

        for (edge in edges) {
            val graph1 = graphsByNodes.getValue(edge.from)
            val graph2 = graphsByNodes.getValue(edge.to)
            if (graph1 != graph2) {
                val union = graph1 + graph2
                for (node in union) {
                    graphsByNodes[node] = union
                }
            }
        }
        return graphsByNodes.values.distinct()
    }

    val nodes = parseNodes(Input.day08)
    val edges = generateEdges(nodes, 1000)

    val graphs = connectGraphs(nodes, edges)

    val result = graphs
        .sortedByDescending { it.size }
        .take(3)
        .fold(1) { acc, graph -> acc * graph.size }

}

fun main() {
    println(Day08a.result.expecting(79056))
}
