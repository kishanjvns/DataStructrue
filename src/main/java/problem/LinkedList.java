package problem;

public class LinkedList{
        Node head;
        
        class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
        
        public String toString(){
            return data+" ->"+next;
        }
    }
        public LinkedList(){
            head = null;
        }
        
        public void add(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
                return;
            }
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        
        
        
        public void printList(){
            if(head == null){
                System.out.println("list is empty");
                return;
            }
            Node current = head;
            while(current != null){
                System.out.print(current.data+", ");
                current = current.next;
            }
        }
        
        public void addAtBegning(int data){
            Node newNode = new Node(data);
            Node temp = head;
            head = newNode;
            newNode.next = temp;
        }
        
        public void reverse(){
            if(head == null){
                return;
            }
            if(head.next == null){
                return;
            }
            Node previous = null;
            Node current = head;
            Node nextNode = head;
            while(current != null){
                nextNode = current.next;
                current.next = previous;
                previous = current;
                current = nextNode;
            }
            head = previous;
            //System.out.print(head);
        }
        
        public int getLength(){
            int counter = 0;
            if(head == null){
                return counter;
            }
            Node current = head;
            while(current != null){
                counter++;
                current = current.next;
            }
            return counter;
        }
        
        public void getMiddleNode(){
            if(head == null){
                throw new IllegalArgumentException("NA");
            }
            int middle = getLength()/2;
            
            Node current = head;
            int counter=1;
            while(counter <= middle){
                counter++;
                current = current.next;
            }
           System.out.println("\n"+current.data);
            
        }
        
        public Node tail(){
            if(head == null){
                return null;
            }
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
             return current;
        }
        
    }
