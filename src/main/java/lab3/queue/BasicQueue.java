package main.java.lab3.queue;

import java.util.LinkedList;

public class BasicQueue<T> implements Queue<T> {
    private LinkedList<T> queue = new LinkedList<>();

    @Override
    public void enqueue(T item) {
        queue.addLast(item);
    }

    @Override
    public T dequeue() {
        return queue.pollFirst();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }
}