package com.btanguay.data.structure.graph;

import java.util.List;

public final class GraphNode<T> {
    public T value;
    public List<GraphNode<T>> connections;

    public GraphNode(T value, List<GraphNode<T>> connections) {
        this.value = value;
        this.connections = connections;
    }
}
