package com.devschool.binarytrees;

import java.util.Comparator;

/**
 * Created by avinash.ranjan on 21/09/17.
 */
public class BasicBinaryTrees<X extends Comparable<X>> {

    private Node root;
    private int size;

    public BasicBinaryTrees() {
        this.root = null;
    }

    private int size() {
        return size;
    }

    public void add(X item) {
        Node node = new Node(item);
        if (root == null) {
            this.root = node;
            System.out.println("Set root :" + node.getItem());
            this.size++;
        } else {
            insert(this.root, node);
        }
    }

    public boolean contain(X item) {
        Node currentNode = getNode(item);
        if (currentNode != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(X item) {
        boolean deleted = false;
        if (this.root == null) {
            return false;
        }
        Node currentNode = getNode(item);
        if (currentNode != null) {
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                unLinkNode(currentNode, null);
                deleted = true;
            } else if (currentNode.getLeft() == null && currentNode.getRight() != null) {
                unLinkNode(currentNode, currentNode.getRight());
                deleted = true;
            } else if (currentNode.getLeft() != null && currentNode.getRight() == null) {
                unLinkNode(currentNode, currentNode.getLeft());
                deleted = true;
            } else {
                Node child = currentNode.getLeft();
                while (child.getLeft() != null && child.getRight() != null) {
                    child = child.getRight();
                }

                child.getParent().setRight(null);
                child.setLeft(currentNode.getLeft());
                child.setRight(currentNode.getRight());

                unLinkNode(currentNode, child);
                deleted = true;
            }
        }
        if (deleted){
            size--;
        }

        return deleted;
    }

    private void unLinkNode(Node currentNode, Node newNode) {
        if (currentNode == this.root) {
            newNode.setLeft(currentNode.getLeft());
            newNode.setRight(currentNode.getRight());
            this.root = newNode;
        } else if (currentNode.getParent().getRight() == currentNode) {
            currentNode.getParent().setRight(newNode);
        } else {
            currentNode.getParent().setLeft(newNode);
        }
    }

    private Node getNode(X item) {
        Node currentNode = this.root;

        while (currentNode != null) {
            int value = item.compareTo(currentNode.getItem());

            if (value == 0) {
                return currentNode;
            } else if (value < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
        return null;
    }

    private void insert(Node parent, Node child) {

        if (child.getItem().compareTo(parent.getItem()) < 0) {

            if (parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            } else {
                insert(parent.getLeft(), child);
            }
        } else if (child.getItem().compareTo(parent.getItem()) > 0) {
            if (parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                this.size++;

            } else {
                insert(parent.getRight(), child);
            }
        }

    }

    private class Node {
        private Node left;
        private Node right;
        private Node parent;
        private X item;

        public Node(X item) {
            this.left = null;
            this.right = null;
            this.parent = null;
            this.item = item;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public X getItem() {
            return item;
        }

        public void setItem(X item) {
            this.item = item;
        }
    }
}
