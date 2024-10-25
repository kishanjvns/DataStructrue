package topic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author KISHAN
 * @implNote This is the second implementation of BTree, this implementation using recursion to insert left and right value to the BTree
 */
public class BinaryTree3<T> {
    private Node<T> root;

    public BinaryTree3(Node<T> root) {
        this.root = root;
    }

    public BinaryTree3() {

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


    public Node addToBTree() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x == -1) {
            return null;
        }
        Node<Integer> temp = new Node<>(x);
        System.out.println("enter the left child of " + x + " : ");
        temp.setLeftChild(addToBTree());
        System.out.println("enter the right child of " + x + " : ");
        temp.setRightChild(addToBTree());
        return temp;
    }

    /**
     * traversing tree in preOrder means NLR , where N stand for Node value, L stands for Left Node and R stand for Right Node
     */
    public void preTraversalRecursive(Node<T> root) {
        preTraversalRecursive(root, 0);
    }

    private void preTraversalRecursive(Node<T> root, int level) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println("|-- " + root.value);
        preTraversalRecursive(root.leftChild, level + 1);
        preTraversalRecursive(root.rightChild, level + 1);
    }

    /**
     * traversing tree in post-order LRN, where N stand for Node value, L stands for Left Node and R stand for Right Node
     */
    public void postOrderTraversalRecursive(Node<T> root) {
        postOrderTraversalRecursive(root, 0);
    }

    private void postOrderTraversalRecursive(Node<T> root, int level) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        preTraversalRecursive(root.leftChild, level + 1);
        preTraversalRecursive(root.rightChild, level + 1);
        System.out.println("|-- " + root.value);
    }

    /**
     * traversing tree in in-order LNR, where N stand for Node value, L stands for Left Node and R stand for Right Node
     */
    public void inOrderTraversalRecursive(Node<T> root) {
        inOrderTraversalRecursive(root, 0);
    }

    private void inOrderTraversalRecursive(Node<T> root, int level) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        preTraversalRecursive(root.leftChild, level + 1);
        preTraversalRecursive(root.rightChild, level + 1);
        System.out.println("|-- " + root.value);
    }

    public void levelOrderTraversal(Node<T> root) {
        if (root == null) {
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> temp = queue.poll();
            if (temp == null) {
                break;
            }
            System.out.println(temp.getValue());
            if (temp.getLeftChild() != null) {
                queue.add(temp.getLeftChild());
            }
            if (temp.getRightChild() != null) {
                queue.add(temp.getRightChild());
            }
        }
    }

    public int sizeOfTree(Node<T> root) {
        AtomicInteger counter = new AtomicInteger();
        return sizeOfTree(counter, root);
    }

    private int sizeOfTree(AtomicInteger counter, Node<T> root) {
        if (root == null) {
            return 0;
        }
        counter.incrementAndGet();
        sizeOfTree(counter, root.leftChild);
        sizeOfTree(counter, root.rightChild);
        return counter.intValue();
    }

    private int sizeOfTree2(Node<T> root) {
        if (root == null) {
            return 0;
        }

        return 1 + sizeOfTree(root.leftChild) +
                sizeOfTree(root.rightChild);
    }

    private int sumOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        return (int) root.value + sumOfTree(root.leftChild) +
                sumOfTree(root.rightChild);
    }

    public int totalLeaf(Node<T> root) {
        if (root != null && root.leftChild == null && root.rightChild == null) {
            return 1;
        }
        if (root != null) {
            return totalLeaf(root.leftChild) + totalLeaf(root.rightChild);
        }
        return 0;
    }

    public int totalNonLeaf(Node<T> root) {
        if(root == null){
            return 0;
        }
        int count = isNonLeaf(root) ? 1 : 0;
        return count + totalNonLeaf(root.leftChild) +totalNonLeaf(root.rightChild);
    }

    public boolean isLeaf(Node<T> root) {
        return root.leftChild == null && root.rightChild ==null;
    }

    public boolean isNonLeaf(Node<T> root) {
        return root.leftChild != null || root.rightChild != null;
    }

    public int height(Node<T> root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.leftChild) ,height(root.rightChild));
    }


    public static void main(String[] args) {
        BinaryTree3<Integer> btree = new BinaryTree3();
        btree.setRoot(btree.addToBTree());
        System.out.println(btree.height(btree.getRoot()));
    }
}
