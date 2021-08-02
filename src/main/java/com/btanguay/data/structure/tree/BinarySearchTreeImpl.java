package com.btanguay.data.structure.tree;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeImpl implements BinarySearchTree {

    private Node root;

    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    @Override
    public void insert(@NotNull int value) {
        if (root == null) {
            root = new Node(value);
        } else {

            Node current = root;
            Node previous = null;

            do {
                previous = current;
                if (current.value > value) {
                    current = current.left;
                    if (current == null) {
                        previous.left = new Node(value);
                    }
                } else if (current.value < value) {
                    current = current.right;
                    if (current == null) {
                        previous.right = new Node(value);
                    }
                } else {
                    return;
                }
            } while (current != null);


        }


    }

    @Override
    public boolean contains(@NotNull int value) {
        if (root == null) return false;

        Node current = root;

        while (current != null) {
            if (current.value == value) return true;
            current = current.value > value ? current.left : current.right;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @NotNull
    @Override
    public List<Integer> inOrder() {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(list, root);
        return list;
    }

    private void inOrder(List<Integer> list, Node node) {
        if (node == null) return;

        if (node.left != null) {
            inOrder(list, node.left);
        }
        list.add(node.value);
        if (node.right != null) {
            inOrder(list, node.right);
        }
    }

    @NotNull
    @Override
    public List<Integer> preOrder() {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(list, root);
        return list;
    }

    private void preOrder(List<Integer> list, Node node) {
        if (node == null) return;

        list.add(node.value);
        if (node.left != null) {
            preOrder(list, node.left);
        }
        if (node.right != null) {
            preOrder(list, node.right);
        }
    }

    @NotNull
    @Override
    public List<Integer> postOrder() {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(list, root);
        return list;
    }

    private void postOrder(List<Integer> list, Node node) {
        if (node == null) return;

        if (node.left != null) {
            postOrder(list, node.left);
        }
        if (node.right != null) {
            postOrder(list, node.right);
        }
        list.add(node.value);
    }
}
