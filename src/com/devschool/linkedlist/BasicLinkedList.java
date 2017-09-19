package com.devschool.linkedlist;

/**
 * Created by avinash.ranjan on 18/09/17.
 */
public class BasicLinkedList<X> {

    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList() {
        first = null;
        last = null;
        nodeCount = 0;
    }

    public void add(X newItem) {
//        when we are adding item for the first time in linkedList
        if (first == null) {
            first = new Node(newItem);
            last = first;
        }
        // if we have item in linkedList then we will create newNode object and put that object to the last node and set last to newLastNode
        else {
            Node newLastNode = new Node(newItem);
            last.setNextNode(newLastNode);
            last = newLastNode;
        }
        nodeCount++;
    }

    public X remove() {
        if (first == null) {
        throw  new IllegalStateException("The linked list is empty and there is no item in the list");
        }
        X nodeItem = first.getNodeItem();
        first = first.getNextNode();
        nodeCount--;
        return nodeItem;
    }

    public int size() {
        return nodeCount;
    }


    private class Node {
        private Node nextNode;
        private X nodeItem;

        public Node(X item) {
            this.nextNode = null;
            this.nodeItem = item;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getNextNode() {

            return nextNode;
        }

        public X getNodeItem() {
            return nodeItem;
        }
    }
}
