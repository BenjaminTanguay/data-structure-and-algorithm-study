package com.btanguay.data.structure.queue;

import org.jetbrains.annotations.NotNull;

public class QueueImpl<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> tail;

    private class Node<T> {
        Node<T> next;
        T value;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    @NotNull
    @Override
    public T dequeue() {
        if (head == null) {
            throw new IllegalStateException("Cannot dequeue from empty queue");
        }

        T value = head.value;
        head = head.next;

        return value;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void enqueue(@NotNull T value) {
        Node<T> node = new Node<>(value, null);

        if (head == null) {
            head = node;
        }
        if (tail == null) {
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }
}
