package com.btanguay;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.btanguay.algorithm.search.binary.BinarySearch;
import com.btanguay.algorithm.search.binary.BinarySearchImpl;
import com.btanguay.algorithm.search.breathfirst.BreathFirstSearch;
import com.btanguay.algorithm.search.depthfirst.DepthFirstSearch;
import com.btanguay.data.structure.linkedlist.LinkedList;
import com.btanguay.data.structure.linkedlist.SingleLinkedList;
import com.btanguay.data.structure.queue.Queue;
import com.btanguay.data.structure.queue.QueueImpl;
import com.btanguay.data.structure.stack.Stack;
import com.btanguay.data.structure.stack.StackImpl;
import com.btanguay.data.structure.tree.*;

public class DataStructureAndAlgorithmModule extends AbstractModule {

    @Override
    protected void configure() {

    }

    @Provides
    public BinarySearch provideBinarySearch() {
        return new BinarySearchImpl();
    }

    @Provides
    public MinHeap provideMinHeapInteger() {
        return new MinHeapImpl();
    }

    @Provides
    public BinarySearchTree provideBinaryTreeInteger() {
        return new BinarySearchTreeImpl();
    }

    @Provides
    public AVLTree provideAVLTreeInteger() {
        return new AVLTreeImpl();
    }

    @Provides
    public Stack<Integer> provideStackInteger() {
        return new StackImpl<>();
    }

    @Provides
    public Queue<Integer> provideQueueInteger() {
        return new QueueImpl<>();
    }

    @Provides
    public LinkedList<Integer> provideSingleLinkedListInteger() {
        return new SingleLinkedList<>();
    }

    @Provides
    public BreathFirstSearch provideBreathFirstSearch() {
        return new BreathFirstSearch();
    }

    @Provides
    public DepthFirstSearch provideDepthFirstSearch() {
        return new DepthFirstSearch();
    }
}
