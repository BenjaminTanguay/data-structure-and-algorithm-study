package com.btanguay.data.structure.tree;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface MinHeap {
    @NotNull
    void insert(int value);
    @NotNull
    Integer extractMin();
    @NotNull
    List<Integer> inOrder();
    @NotNull
    List<Integer> preOrder();
    @NotNull
    List<Integer> postOrder();

    boolean isEmpty();
}
