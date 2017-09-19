package com.devschool.linkedlist;

/**
 * Created by avinash.ranjan on 18/09/17.
 */
public class BasicLinkedList<X> {

    private Node first;
    private Node last;

    public BasicLinkedList() {
        first = null;
        last = null;
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

        public Node getNextNode (){

            return nextNode;
        }

        public X getNodeItem(){
            return nodeItem;
        }
    }
}
