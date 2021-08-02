package com.btanguay.data.structure.stack;

import org.jetbrains.annotations.NotNull;

public interface Stack<T> {

    @NotNull
    T peek();
    void push(@NotNull T value);
    @NotNull
    T pop();
    int size();

    boolean isEmpty();
}
