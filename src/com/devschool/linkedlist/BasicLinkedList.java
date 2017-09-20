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

    public void insert(X item, int position) {
        if (position > size()) {
            throw new IllegalStateException("The linked list is smaller tha the position you want to insert");
        }

        Node currentNode = first;
        for (int i = 0; i < position && currentNode != null; i++) {
            currentNode = currentNode.getNextNode();
        }

        Node newNode = new Node(item);
        Node nextNode = currentNode.getNextNode();
        currentNode.setNextNode(newNode);
        newNode.setNextNode(nextNode);
        nodeCount++;
    }

    public X removeAt(int position) {
        if (first == null) {
            throw new IllegalStateException("The linkedList is empty and there is not item to remove");
        }
        Node currentNode = first;
        Node previousNode = first;

        for (int i = 0; i < position && currentNode != null; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        X nodeItem = currentNode.getNodeItem();
        previousNode.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return nodeItem;
    }

    public X remove() {
        if (first == null) {
            throw new IllegalStateException("The linked list is empty and there is no item in the list");
        }
        X nodeItem = first.getNodeItem();
        first = first.getNextNode();
        nodeCount--;
        return nodeItem;
    }

    public X get(int position) {
        if (first == null) {
            throw new IllegalStateException("The linkedList is empty and there is no item to get");
        }
        Node currentNode = first;
        for (int i = 0; i < size() && currentNode != null; i++) {
            if (i == position) {
                return currentNode.getNodeItem();
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    public int find(X item) {
        if (first == null) {
            throw new IllegalStateException("The linkedList is empty and there is no item to get");
        }
        Node currentNode = first;
        for (int i = 0; i < size() && currentNode != null; i++) {
            if (currentNode.getNodeItem().equals(item)) {
                return i;
            }
            currentNode = currentNode.getNextNode();
        }
        return -1;
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
