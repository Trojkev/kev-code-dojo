package practice;

import java.util.NoSuchElementException;

public class Queue {
    private int[] array = new int[10];
    private int front = -1;
    private int rear = -1;
    private int N = array.length;

    boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    boolean isFull() {
        return false;
    }

    void enqueue(int x) {
        if (isFull())
            return;
        else if (isEmpty())
            front = rear = 0;
        else
            rear = (rear + 1) % N;
        array[rear] = x;
    }

    int dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("The Queue is empty");
        else if (front == rear) {
            front = rear = -1;
        }
        return array[front];
    }
}
