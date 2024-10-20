package problem;

public  class DLinkedList {
		Node head;

		class Node {
			Node next;
			Node prev;
			int data;

			public Node(int data) {
				this.data = data;
				this.prev = null;
				this.next = null;
			}
		}

		public void delete(int data) {
			Node temp = head;
			if(data == head.data) {
				head.next.prev=null;
				head = head.next;
				return;
			}
			while (temp != null) {
				if (data == temp.next.data) {
					//Node nodeToDelete = temp.next;
					temp.next = temp.next.next;
					if(null != temp.next)
						temp.next.prev = temp;
					break;
				}
				temp = temp.next;
			}
		}
		public boolean isContain(int data) {
			boolean flag = false;
			Node temp = head;
			while (temp != null) {
				if (data == temp.data) {
					flag = true;
					break;
				}
				temp = temp.next;
			}
			return flag;
		}

		public void add(int data) {
			Node newNode = new Node(data);
			if (head == null) {
				head = newNode;
				return;
			}
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			newNode.prev = current;
			current.next = newNode;
		}

		public void addAtBegining(int data) {
			Node newNode = new Node(data);
			if (head == null) {
				head = newNode;
				return;
			}
			Node temp = head;
			head = newNode;
			temp.prev = head;
			head.next = temp;

		}

		public void addAtLast(int data) {
			Node newNode = new Node(data);
			if (head == null) {
				head = newNode;
				return;
			}
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			newNode.prev = temp;
			temp.next = newNode;
		}

		public void printForward() {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + "->");
				temp = temp.next;
			}
		}

		public void printBackward() {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			while (temp != null) {
				System.out.print(temp.data + "->");
				temp = temp.prev;
			}
			// System.err.print("null");
		}
		
		public void reverse() {
			Node curr=head;
			Node temp = null;
			while(curr!=null) {
				Node nextPointer = curr.next;
				curr.next = temp;
				curr.prev = nextPointer;
				temp = curr;
				curr = nextPointer;
			}
			head = temp;
		}
		
		public Node getTail() {
			if(head == null || head.next == null) {
				return null;
			}
			Node curr = head;
			while(curr.next != null) {
				curr=curr.next;
			}
			return curr;
		}
		
		public void rotateCounterClockWise(int position) {
			Node tail = getTail();
			for(int i=0;i<position;i++) {
			 tail = rotateCounterClockWise(tail);
			}
		}
		public Node rotateCounterClockWise(Node tail) {
			if(head == null || head.next == null) {
				return null;
			}
			Node temp = head;
			head = head.next;
			temp.next =null;
			//Node tail =getTail();
			temp.prev = tail;
			tail.next = temp;
			return temp;
		}

		public String toString() {
			return head.toString();
		}
	}
