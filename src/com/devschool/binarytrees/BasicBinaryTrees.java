package com.devschool.binarytrees;

import java.util.Comparator;

/**
 * Created by avinash.ranjan on 21/09/17.
 */
public class BasicBinaryTrees<X extends Comparator<X>> {

    private Node root;
    private int size;

    public BasicBinaryTrees() {
        this.root = null;
    }

    private int size(){
        return size;
    }

    public void add(X item){

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
