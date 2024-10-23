package topic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * @author KISHAN
 * @implNote This is the second implementation of BTree, this implementation using recursion to insert left and right value to the BTree
 * */
public class BinaryTree2<T> {
    private Node<T> root;

    public BinaryTree2(Node<T> root) {
        this.root = root;
    }
    public BinaryTree2() {

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


    public Node addToBTree(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if(x == -1){
            return null;
        }
        Node<Integer> temp = new Node<>(x);
        System.out.println("enter the left child of "+x+" : ");
        temp.setLeftChild(addToBTree());
        System.out.println("enter the right child of "+x+" : ");
        temp.setRightChild(addToBTree());
        return temp;
    }
    /**
     traversing tree in preOrder means NLR , where N stand for Node value, L stands for Left Node and R stand for Right Node
     */
    public void  preTraversalRecursive(Node<T> root){
        preTraversalRecursive(root,0);
    }
    private void  preTraversalRecursive(Node<T> root,int level){
        if(root == null){
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println("|-- " + root.value);
        preTraversalRecursive(root.leftChild, level + 1);
        preTraversalRecursive(root.rightChild, level + 1);
    }
    /** traversing tree in post-order LRN, where N stand for Node value, L stands for Left Node and R stand for Right Node */
    public void  postOrderTraversalRecursive(Node<T> root){
        postOrderTraversalRecursive(root,0);
    }
    private void  postOrderTraversalRecursive(Node<T> root,int level){
        if(root == null){
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        preTraversalRecursive(root.leftChild, level + 1);
        preTraversalRecursive(root.rightChild, level + 1);
        System.out.println("|-- " + root.value);
    }
    /** traversing tree in in-order LNR, where N stand for Node value, L stands for Left Node and R stand for Right Node */
    public void  inOrderTraversalRecursive(Node<T> root){
        inOrderTraversalRecursive(root,0);
    }
    private void  inOrderTraversalRecursive(Node<T> root,int level){
        if(root == null){
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
        if(root == null){
            return;
        }
        Queue<Node<T>> queue =new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node<T> temp = queue.poll();
            if(temp == null){
                break;
            }
            System.out.println(temp.getValue());
            if(temp.getLeftChild() != null){
                queue.add(temp.getLeftChild());
            }if(temp.getRightChild() != null){
                queue.add(temp.getRightChild());
            }
        }
    }
    public static void main(String[] args) {
        BinaryTree2<Integer> btree =new BinaryTree2();
        btree.setRoot(btree.addToBTree());
        btree.levelOrderTraversal(btree.getRoot());
    }
}
