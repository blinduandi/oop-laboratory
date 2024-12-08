package main.java.lab3.queue;

import java.util.PriorityQueue;

public class PriorityQueueImpl<T extends Comparable<T>> implements Queue<T> {
    private PriorityQueue<T> priorityQueue = new PriorityQueue<>();

    @Override
    public void enqueue(T item) {
        priorityQueue.add(item);
    }

    @Override
    public T dequeue() {
        return priorityQueue.poll();
    }

    @Override
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    @Override
    public int size() {
        return priorityQueue.size();
    }
}