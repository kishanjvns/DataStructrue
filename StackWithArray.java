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
            if(top == capacity-1){
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
        
        public boolean isFull(){
            return top == capacity-1;
        }
        
        public int size(){
            return top+1;
        }
        public String toString(){
            return Arrays.toString(dataStore);
        }
    }
	public static void main(String[] args) {
		Stack s=new Stack(3);
		s.push(1);
		s.push(2);
		s.push(3);
		
		System.out.println("stack size is: "+s.size() );
		
		for(int i=0;i<s.size(); i++ ){
		    System.out.println(s.pop());
		}
		
		System.out.println(s);
	}
}
