package org.example.prep.gs;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Deque {
    private int capacity=5;
    private int[] arr;
    private int rear,front;
    public Deque(){
        arr=new int[capacity];
        front=-1;
        rear=-1;
    }
    public boolean isEmpty(){
        return rear==-1;
    }
    private boolean isFull() {
        // Check if the next rear position is equal to the front position
        return (rear +1) == front || (front == 0 && rear == capacity - 1);
    }

    public void  pushFront(int val){
        if (!isFull()) {
            if (front == -1 && rear == -1) {
                front = rear = 0;
            }
            // Adjust the front pointer
            front = (front - 1 + capacity) % capacity;
            arr[front] = val;
        }
    }
    public static void main(String[] args) {
        System.out.println((-1+5)%5);
        Deque d= new Deque();
       for (int i=0;i<=5;i++){
           d.pushFront(i*7/3*i);
       }

    }

}


