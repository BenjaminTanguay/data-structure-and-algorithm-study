package com.btanguay.algorithm.search.breathfirst;

import com.btanguay.data.structure.graph.GraphNode;

import java.util.*;

/**
 * Important to remember: Breath first uses a queue whereas Depth first is recursive.
 */
public final class BreathFirstSearch {

    private Set<GraphNode<Integer>> seen = new HashSet<>();
    private Queue<GraphNode<Integer>> queue = new LinkedList<>();

    public List<Integer> search(GraphNode<Integer> root) {
        ArrayList<Integer> integers = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {

            GraphNode<Integer> node = queue.remove();
            if (!seen.contains(node)) {
                seen.add(node);
                integers.add(node.value);
                node.connections.forEach(connection -> {
                    queue.add(connection);
                });
            }
        }

        return integers;
    }
}
