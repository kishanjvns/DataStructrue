package topic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree<T> {
    private Node<T> root;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }
    public BinaryTree() {
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public static class Node<T> {
        private T value;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "value=" + value +
                    ", leftChild=" + (leftChild != null ? leftChild.value : "----") +
                    ", rightChild=" + (rightChild != null ? rightChild.value : "----");
        }
    }

    public static void initTree() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the root value ");
        int rootVal = sc.nextInt();
        Node<Integer> root = new Node<>(rootVal);
        BinaryTree<Integer> tree = new BinaryTree<>(root);

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<Integer> current = queue.poll();
            System.out.println("Enter the left child of " + current.value);
            int leftChildVal = sc.nextInt();
            if (leftChildVal != -1) {
                current.setLeftChild(new Node<>(leftChildVal));
                queue.add(current.leftChild);
            }

            System.out.println("Enter the right child of " + current.value);
            int rightChildVal = sc.nextInt();
            if (rightChildVal != -1) {
                current.setRightChild(new Node<>(rightChildVal));
                queue.add(current.rightChild);
            }

        }
        //System.out.println(tree);
        print(root, 0);
    }



    public static <T> void print(Node<T> root, int level) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println("|-- " + root.value);
        print(root.leftChild, level + 1);
        print(root.rightChild, level + 1);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt= new BinaryTree<>();
        initTree();

    }
}
