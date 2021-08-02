package com.btanguay.algorithm.search.depthfirst;

import com.btanguay.data.structure.graph.GraphNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class DepthFirstSearch {

    private Set<GraphNode<Integer>> seen = new HashSet<>();

    public List<Integer> search(GraphNode<Integer> root) {
        ArrayList<Integer> output = new ArrayList<>();
        search(root, output);
        return output;
    }

    private void search(GraphNode<Integer> node, List<Integer> output) {
        if (!seen.contains(node)) {
            seen.add(node);
            output.add(node.value);
            node.connections.forEach(connection -> {
                search(connection, output);
            });
        }
    }
}
