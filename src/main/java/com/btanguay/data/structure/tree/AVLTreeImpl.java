package com.btanguay.data.structure.tree;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AVLTreeImpl implements AVLTree {

    private Node root;

    private enum BalanceState {
        BALANCED,
        LEFT_LEFT,
        LEFT_RIGHT,
        RIGHT_RIGHT,
        RIGHT_LEFT;
    }

    private enum Evaluation {
        EQUAL,
        LEFT,
        RIGHT;
    }

    private class Node {
        int value;
        private int depth;
        private Node left, right, parent;

        public Node(int value, Node parent) {
            this.value = value;
            this.depth = 1;
            setParent(parent);
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Node getParent() {
            return parent;
        }

        public void setLeft(Node node) {
            this.left = node;
            refreshDepth();
            if (node != null) {
                node.setParent(this);
            }
        }

        public void setRight(Node node) {
            this.right = node;
            refreshDepth();
            if (node != null) {
                node.setParent(this);
            }
        }

        public void setChild(Node node) {
            if (node != null) {
                switch (resolveEvaluation(node.value)) {
                    case LEFT -> setLeft(node);
                    case RIGHT -> setRight(node);
                }
            }
        }

        public void setParent(Node node) {
            this.parent = node;
            if (node != null) {
                this.parent.refreshDepth();
            }
        }

        public int getBalance() {
            return getDepth(getLeft()) - getDepth(getRight());
        }

        public void refreshDepth() {
            this.depth = Math.max(getDepth(getLeft()), getDepth(getRight())) + 1;
        }

        private int getDepth(Node node) {
            return node == null ? 0 : node.depth;
        }

        public Evaluation resolveEvaluation(int value) {
            if (this.value == value) {
                return Evaluation.EQUAL;
            } else if (value < this.value) {
                return Evaluation.LEFT;
            } else {
                return Evaluation.RIGHT;
            }
        }

    }

    private BalanceState resolveBalance(@NotNull Node node, int value) {
        int balance = node.getBalance();
        if (balance <= 1 && balance >= -1) {
            return BalanceState.BALANCED;
        } else if (balance > 1) {
            return switch(node.left.resolveEvaluation(value)) {
                case LEFT -> BalanceState.LEFT_LEFT;
                case RIGHT -> BalanceState.LEFT_RIGHT;
                default -> throw new IllegalStateException("Cannot have equal node in the tree when resolving the balance!");
            };
        } else {
            return switch(node.right.resolveEvaluation(value)) {
                case LEFT -> BalanceState.RIGHT_LEFT;
                case RIGHT -> BalanceState.RIGHT_RIGHT;
                default -> throw new IllegalStateException("Cannot have equal node in the tree when resolving the balance!");
            };
        }
    }

    private void rotateLeft(Node newParent) {
        Node newLeft = newParent.getParent();
        Node rightSubtree = newParent.getLeft();
        Node grandParent = newLeft.getParent();

        newLeft.setRight(rightSubtree);
        newParent.setLeft(newLeft);
        newParent.setParent(grandParent);
        if (grandParent == null) {
            this.root = newParent;
        } else {
            grandParent.setChild(newParent);
        }
    }

    private void rotateRight(Node newParent) {
        Node newRight = newParent.getParent();
        Node leftSubtree = newParent.getRight();
        Node grandParent = newRight.getParent();

        newRight.setLeft(leftSubtree);
        newParent.setRight(newRight);
        newParent.setParent(grandParent);
        if (grandParent == null) {
            this.root = newParent;
        } else {
            grandParent.setChild(newParent);
        }
    }


    @Override
    public void insert(@NotNull int value) {
        if (this.root == null) {
            this.root = new Node(value, null);
            return;
        }

        Node parent = root;
        boolean isParentFound = false;

        while(!isParentFound) {
            switch(parent.resolveEvaluation(value)) {
                case EQUAL -> {
                    // Do nothing, we don't allow duplicates in the tree
                    return;
                }
                case LEFT -> {
                    if (parent.getLeft() == null) {
                        isParentFound = true;
                        parent.setLeft(new Node(value, parent));
                    } else {
                        parent = parent.getLeft();
                    }
                }
                case RIGHT -> {
                    if (parent.getRight() == null) {
                        isParentFound = true;
                        parent.setRight(new Node(value, parent));
                    } else {
                        parent = parent.getRight();
                    }
                }
            }
        }

        while ((parent = parent.getParent()) != null) {
            parent.refreshDepth();
            switch (resolveBalance(parent, value)) {
                case LEFT_LEFT -> rotateRight(parent.getLeft());
                case RIGHT_RIGHT -> rotateLeft(parent.getRight());
                case LEFT_RIGHT -> {
                    Node target = parent.getLeft().getRight();
                    rotateLeft(target);
                    rotateRight(target);
                }
                case RIGHT_LEFT -> {
                    Node target = parent.getRight().getLeft();
                    rotateRight(target);
                    rotateLeft(target);
                }
                default -> {
                    // Do nothing. Things are balanced!
                }
            }
        }
    }


    @Override
    public boolean contains(@NotNull int value) {
        Node node = root;
        while (node != null) {
            switch (node.resolveEvaluation(value)) {
                case LEFT -> node = node.getLeft();
                case RIGHT -> node = node.getRight();
                case EQUAL -> {
                    return true;
                }
            }
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
        inOrder(root, list);
        return list;
    }

    private void inOrder(Node node, List<Integer> list) {
        if (node.left != null) {
            inOrder(node.left, list);
        }
        list.add(node.value);
        if (node.right != null) {
            inOrder(node.right, list);
        }
    }

    @NotNull
    @Override
    public List preOrder() {
        return new ArrayList<>();
    }

    @NotNull
    @Override
    public List postOrder() {
        return new ArrayList<>();
    }
}
