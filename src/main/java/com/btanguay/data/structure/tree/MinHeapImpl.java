package com.btanguay.data.structure.tree;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MinHeapImpl implements MinHeap {

    private Integer[] heap = new Integer[100];
    private int nextIndex = 0;

    @Inject
    public MinHeapImpl() {
        for (int i = 0; i < 100; ++i) {
            this.heap[i] = null;
        }
    }

    private void add(int value) {
        this.heap[nextIndex] = value;
        nextIndex += 1;

        // A new value added should never have its child's index be out of bound. Max child index = newIndex * 2 + 2.
        // Triple the value when we are at one third is a simple way to keep things safe.
        if (nextIndex == (heap.length / 3)) {
            Integer[] newHeap = new Integer[heap.length * 3];
            for (int i = 0; i < heap.length; ++i) {
                newHeap[i] = heap[i];
            }
            for (int i = heap.length; i < newHeap.length; ++i) {
                newHeap[i] = null;
            }
            this.heap = newHeap;
        }
    }

    private Integer removeMin() {
        if (this.heap == null || this.heap.length == 0) {
            throw new IllegalStateException("Cannot extract min on null or empty heap!");
        }
        Integer min = this.heap[0];
        this.heap[0] = null;
        int lastIndex = nextIndex - 1;
        swap(0, lastIndex);
        nextIndex = lastIndex;
        return min;
    }

    private void swap(int index1, int index2) {
        Integer temp = this.heap[index1];
        this.heap[index1] = this.heap[index2];
        this.heap[index2] = temp;
    }


    private int getLeftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getMinChildIndex(int parentIndex) {
        int leftIndex = getLeftChildIndex(parentIndex);
        int rightIndex = getRightChildIndex(parentIndex);
        Integer left = this.heap[leftIndex];
        Integer right = this.heap[rightIndex];

        if (left == null) {
            return rightIndex;
        } else if (right == null) {
            return leftIndex;
        } else {
            return left < right ? leftIndex : rightIndex;
        }
    }

    private boolean isParentSmallerThanChild(int parentIndex, int childIndex) {
        return this.heap[childIndex] == null || this.heap[childIndex] > this.heap[parentIndex];
    }

    @Override
    public void insert(int value) {
        add(value);

        int childIndex = nextIndex - 1;
        int parentIndex = getParentIndex(childIndex);

        while (!isParentSmallerThanChild(parentIndex, childIndex) && childIndex != 0) {
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = getParentIndex(parentIndex);
        }
    }

    @Override
    @NotNull
    public Integer extractMin() {
        if (this.heap == null || this.heap.length == 0) {
            throw new IllegalStateException("Cannot extract min on null or empty heap!");
        }

        Integer min = removeMin();

        int parentIndex = 0;
        int childIndex = getMinChildIndex(parentIndex);

        while (!isParentSmallerThanChild(parentIndex, childIndex) && this.heap[childIndex] != null) {
            swap(parentIndex, childIndex);
            parentIndex = childIndex;
            childIndex = getMinChildIndex(childIndex);
        }
        return min;
    }


    @Override
    @NotNull
    public List<Integer> inOrder() {
        ArrayList<Integer> list = new ArrayList<>();

        inOrder(0, list);

        return list;
    }

    private void inOrder(int currentIndex, List<Integer> list) {
        int leftChildIndex = getLeftChildIndex(currentIndex);
        int rightChildIndex = getRightChildIndex(currentIndex);

        if (heap[leftChildIndex] != null) {
            inOrder(leftChildIndex, list);
        }

        if (heap[currentIndex] != null) {
            list.add(heap[currentIndex]);
        }

        if (heap[rightChildIndex] != null) {
            inOrder(rightChildIndex, list);
        }
    }

    @Override
    @NotNull
    public List<Integer> preOrder() {
        ArrayList<Integer> list = new ArrayList<>();

        preOrder(0, list);

        return list;
    }

    private void preOrder(int currentIndex, List<Integer> list) {
        int leftChildIndex = getLeftChildIndex(currentIndex);
        int rightChildIndex = getRightChildIndex(currentIndex);

        if (heap[currentIndex] != null) {
            list.add(heap[currentIndex]);
        }

        if (heap[leftChildIndex] != null) {
            preOrder(leftChildIndex, list);
        }


        if (heap[rightChildIndex] != null) {
            preOrder(rightChildIndex, list);
        }
    }


    @Override
    @NotNull
    public List<Integer> postOrder() {
        ArrayList<Integer> list = new ArrayList<>();

        postOrder(0, list);

        return list;
    }

    @Override
    public boolean isEmpty() {
        return Arrays.stream(heap).allMatch(Objects::isNull);
    }


    private void postOrder(int currentIndex, List<Integer> list) {
        int leftChildIndex = getLeftChildIndex(currentIndex);
        int rightChildIndex = getRightChildIndex(currentIndex);

        if (heap[leftChildIndex] != null) {
            postOrder(leftChildIndex, list);
        }

        if (heap[rightChildIndex] != null) {
            postOrder(rightChildIndex, list);
        }

        if (heap[currentIndex] != null) {
            list.add(heap[currentIndex]);
        }

    }


}
