package com.btanguay.algorithm.search.common

import com.google.inject.Inject
import com.btanguay.data.structure.graph.GraphNode
import io.cucumber.guice.ScenarioScoped
import io.cucumber.java.en.Given

@ScenarioScoped
class GraphSteps @Inject constructor() {

    lateinit var graphRoot: GraphNode<Int>

    @Given("a graph exists with nodes linked in the following order")
    fun `a graph exists with nodes linked in the following order`(nodes: List<List<Int>>) {
        val nodesWithConnections = nodes.map { GraphConnection(it.get(0), it.get(1)) }
        val allNodes = nodes
            .flatten()
            .toSet()
            .sorted()
            .map { GraphNode(it, ArrayList()) };

        allNodes
            .forEach {
                nodesWithConnections.filter { graphConnection -> graphConnection.from == it.value }
                    .sortedBy { graphConnection -> graphConnection.from }
                    .forEach { graphConnection ->
                        it.connections.add(
                            allNodes.find { node -> node.value == graphConnection.to }
                        )
                    }
            }

        this.graphRoot = allNodes[0];
    }
}

class GraphConnection<T>(val from: T, val to: T)