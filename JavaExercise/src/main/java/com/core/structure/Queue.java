package com.core.structure;

public class Queue<T> {


    T[] arr;
    int front = -1;
    int back = 0;
    int maxSize;
    int currentSize;

    public Queue(int size) {
        currentSize = 0;
        maxSize = size;
        arr = (T[]) new Object[size];
    }


    public void enqueue(T t) {

        if (!isFull()) {

            if (front >= maxSize - 1) {
                front = -1;
            }

            arr[++front] = t;
            currentSize++;
        } else {
            System.err.println("Queue is Full");
        }


    }

    public T dequeue() {

        if (isEmpty()) {
            System.err.println("Queue is Empty");
            return null;
        } else {

            if (back > maxSize - 1) {
                back = 0;
            }

            currentSize--;
            return arr[back++];

        }
    }


    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public static void main(String[] args) {


        Queue queue = new Queue(4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(8);
        queue.enqueue(9);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.enqueue(14);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }

}
