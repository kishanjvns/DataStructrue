package problem;

public class StackLinkedList {

	static class Stack {

		final class Node {
			int data;
			Node next;

			public Node() {
				this.data = -1;
				this.next = null;
			}

			public Node(int data) {
				this.data = data;
				this.next = null;
			}

			public String toString() {
				return data + "->" + next;
			}
		}

		private Node top;

		public void push(int data) {
			Node newNode = new Node(data);
			if (top == null) {
				top = newNode;
				return;
			}
			Node temp = top;
			top = newNode;
			top.next = temp;
		}

		public int pop() {
			if (top == null) {
				return -1;
			}
			int data = top.data;
			top = top.next;
			return data;
		}

		public String toString() {
			return top.toString();
		}

		public int peek() {
			return top.data;
		}

		public boolean isEmpty() {
			return top == null;
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s);

		System.err.println(s.pop());
		System.out.println(s);
	}

}
