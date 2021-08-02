package com.btanguay.data.structure.linkedlist;

import org.jetbrains.annotations.NotNull;

public class SingleLinkedList<T> implements LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void addFirst(@NotNull T element) {
        Node<T> node = new Node(element, head);
        this.head = node;
        if (tail == null) {
            tail = node;
        }
    }

    @Override
    public void addLast(@NotNull T element) {
        Node<T> node = new Node(element, null);
        if (head == null) {
            head = node;
        }
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
    }

    @Override
    public void addAtIndex(@NotNull T element, int index) {
        // a -> b -> d
        // add c in index 2
        // a -> b -> c -> d

        // a -> b -> d
        // add c in index 3
        // a -> b -> d -> c

        if (index == 0) {
            addFirst(element);
        } else {
            Node<T> previous = head;
            Node<T> current = head.next;

            int i = 1;
            while (i != index && current != null) {
                previous = current;
                current = current.next;
                ++i;
            }

            if (i != index) {
                throw new IllegalStateException("Cannot add at index outside of linked list!");
            } else {
                Node<T> node = new Node(element, current);
                previous.next = node;
            }

        }
    }

    @Override
    public boolean contains(@NotNull T element) {
        if (head == null) {
            return false;
        } else {
            Node<T> node = head;
            do {
                if (node.value == element) {
                    return true;
                }
            } while ((node = node.next) != null);
            return false;
        }
    }

    @NotNull
    @Override
    public T remove(int index) {
        if (index == 0) {
            T element = head == null ? null : head.value;
            if (head != null) {
                head = head.next;
            }
            return element;
        }

        Node<T> previous = head;
        Node<T> current = head.next;
        int i = 1;

        while (i != index && current != null) {
            previous = current;
            current = current.next;
            ++i;
        }

        if (current == null) {
            throw new IllegalStateException("Cannot remove null element!");
        } else {
            T element = current.value;
            previous.next = current.next;
            return element;
        }
    }

    @NotNull
    @Override
    public T get(int index) {
        if (head == null) {
            throw new IllegalStateException("Cannot return null value");
        }

        Node<T> current = head;
        int i = 0;

        while (i != index && current != null) {
            current = current.next;
            ++i;
        }

        if (current == null) {
            throw new IllegalStateException("Cannot get element outside of linked list!");
        } else {
            return current.value;
        }
    }
}
