package problem;

import java.util.*;
public class StackWithArray
{
   static class Stack{
        private int top;
        private int[] dataStore;
        private int capacity;
        
        public Stack(){
            this.top=-1;
            this.capacity = 8;
            this.dataStore = new int[capacity];
        }
        public Stack(int capacity){
            this.top=-1;
            this.capacity = capacity;
            this.dataStore = new int[capacity];
        }
        public boolean isEmpty(){
            if(top==-1){
                return true;
            }
            return false;
        }
        
        public void push(int data){
            if(top < capacity-1){
                top++;
                dataStore[top] = data;
                return;
            }else{
                System.out.println("stack is full");
            }
        }
        
        public int pop(){
            if(isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }
            int data = dataStore[top];
            dataStore[top] =-1;
            top--;
            return data;
        }
        
        public int peek(){
            if(isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }
            return dataStore[top];
        }
        
        public void reverse(){
            for(int i=0;i< dataStore.length/2;i++){
                int temp =dataStore[i];
                dataStore[i] = dataStore[dataStore.length-1-i];
                dataStore[dataStore.length-1-i] = temp;
            }
        }
        
		public void reverse2() {
			if (isEmpty()) {
				return;
			}
			int value = pop();
			reverse2();
			insertAtBottom(value);
		}

		public void insertAtBottom(int data) {
			if (isEmpty()) {
				push(data);
			} else {
				int x = pop();
				insertAtBottom(data);
				push(x);
			}
		}
        
        public boolean isFull(){
            return top == capacity-1;
        }
        
        
        public void sort() {
        	if(isEmpty()) {
        		return;
        	}
        	int x = pop();
        	sort();
        	compareAndPush(x);
        }
        private void compareAndPush(int data) {
        	if(isEmpty()) {
        		push(data);
        	}else {
        		int x = pop();
        		if(x < data) {
        			compareAndPush(data);
        		}else {
        			push(x);
        			push(data);
        			return;
        		}
        		push(x);
        	}
        }
        
        public int size(){
            return top+1;
        }
        public String toString(){
            return Arrays.toString(dataStore);
        }
    }
	public static void main(String[] args) {
		Stack s=new Stack(5);
//		s.push(1);
//		s.push(2);
//		s.push(3);
//		s.push(4);
//		s.push(5);
		
		s.push(2);
		s.push(4);
		s.push(6);
		s.push(1);
		s.push(3);

		
		
		System.out.println(s);
		
		//s.reverse();
		//s.reverse2();
		s.sort();
		
		System.out.println(s);
//		
//		System.out.println("top element: "+s.peek());
	}
}
