package com.devschool.stack;


public class BasicStack<X> {

    private X[] data;
    private int stackPointer;

    public BasicStack() {

        data = (X[]) new Object[1000];
        stackPointer = 0;
    }

    public void push(X newItem) {
        data[stackPointer++] = newItem;

    }

    public X pop() {
        if (stackPointer == 0) {
            throw new IllegalStateException("No more item on stack");
        }

        return data[--stackPointer];
    }

    public boolean contains(X items) {
        boolean found = false;
        for (int i = 0; i < stackPointer; i++) {
            if (data[i].equals(items)) {
                found = true;
                break;
            }
        }

        return found;
    }

    public X access(X item) {
        while (stackPointer > 0) {
            X tempItem = pop();
            if (item.equals(tempItem)) {
                return tempItem;
            }
        }
        throw new IllegalArgumentException("Could not find the item on the stack " + item);
    }

    public int size() {
        return stackPointer;
    }
}
