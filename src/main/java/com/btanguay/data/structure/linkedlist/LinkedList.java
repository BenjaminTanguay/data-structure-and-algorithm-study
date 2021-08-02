package com.btanguay.data.structure.linkedlist;

import org.jetbrains.annotations.NotNull;

public interface LinkedList<T> {
    void addFirst(@NotNull T element);
    void addLast(@NotNull T element);
    void addAtIndex(@NotNull T element, int index);
    boolean contains(@NotNull T element);

    @NotNull
    T remove(int index);

    @NotNull
    T get(int index);
}
