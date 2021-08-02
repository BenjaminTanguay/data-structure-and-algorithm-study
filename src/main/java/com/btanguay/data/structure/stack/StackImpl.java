package com.btanguay.data.structure.stack;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class StackImpl<T> implements Stack<T> {

    private Node<T> head;
    private int size = 0;

    private class Node<T> {
        T element;
        Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Inject
    public StackImpl() {

    }

    @Override
    @NotNull
    public T peek() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty. Cannot peak from it!");
        }
        return head.element;
    }

    @Override
    public void push(@NotNull T value) {
        head = new Node<>(value, head);
        ++size;
    }

    @Override
    @NotNull
    public T pop() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty. Cannot pop from it!");
        }
        T value = head.element;
        head = head.next;
        --size;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
