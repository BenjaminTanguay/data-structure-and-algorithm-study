package com.btanguay.data.structure.queue;

import org.jetbrains.annotations.NotNull;

public interface Queue<T> {

    @NotNull
    T dequeue();

    boolean isEmpty();

    void enqueue(@NotNull T value);

}
