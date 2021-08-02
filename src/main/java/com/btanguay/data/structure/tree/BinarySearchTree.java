package com.btanguay.data.structure.tree;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface BinarySearchTree {
    void insert(@NotNull int value);
    boolean contains(@NotNull int value);
    boolean isEmpty();
    @NotNull
    List<Integer> inOrder();
    @NotNull
    List<Integer> preOrder();
    @NotNull
    List<Integer> postOrder();
}
