package com.devschool.queue;

/**
 * Created by avinash.ranjan on 18/09/17.
 */
public class BasicQueue<X> {
    private X[] data;
    private int front;
    private int end;


    public BasicQueue() {
        this(1000); // init data with 1000
    }

    public BasicQueue(int size) {
        this.front = -1;
        this.end = -1;
        data = (X[]) new Object[size]; // init data with given size
    }

    public int size() {
        if (front == -1 && end == -1) {
            return 0;
        } else {
            return end - front + 1;
        }
    }

    public void enQueue(X newItem) {
        if ((end + 1) % data.length == front) {
            throw new IllegalStateException("The Queue is full");
        } else if (size() == 0) {
            front++;
            end++;
            data[end] = newItem;
        } else {
            end++;
            data[end] = newItem;
        }

    }

    public X deQueue() {
        X item = null;
        if (size() == 0) {
            throw new IllegalStateException("Can't deque because the queue is empty!");
        } else if (end == front) {
            item = data[front];
            data[front] = null; // to free up the memory
            front = -1;
            end = -1;
        } else {
            item = data[front];
            data[front] = null; // to free up the memory
            front++;
        }
        return item;
    }

    public boolean contains(X item) {
        boolean found = false;
        if (size() == 0) {
            return found;
        } else {
            for (int i = front; i < end; i++) {
                if (data[i].equals(item)) {
                    found = true;
                    break;
                }
            }
        }

        return found;
    }

    public X access(int position) throws IllegalAccessException {
        if (size() == 0 || position > size()) {
            throw new IllegalStateException("No item in the queue or the position is greater than size of the queue");
        }
        int trueIndex = 0;

        for (int i = front; i < end; i++) {
            if (trueIndex == position) {
                return data[i];
            }
            trueIndex++;
        }

        throw new IllegalAccessException("Couldn't get queue item at position: " + position);


    }
}
