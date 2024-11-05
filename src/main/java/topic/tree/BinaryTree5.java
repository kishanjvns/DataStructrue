package topic.tree;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author KISHAN
 * @implNote This is the second implementation of BTree, this implementation using recursion to insert left and right value to the BTree
 */
public class BinaryTree5<T> {
    private Node<T> root;

    public BinaryTree5(Node<T> root) {
        this.root = root;
    }

    public BinaryTree5() {

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


    public boolean isLeaf(Node<T> root) {
        return root.leftChild == null && root.rightChild == null;
    }

    public boolean isNonLeaf(Node<T> root) {
        return root.leftChild != null || root.rightChild != null;
    }

    public int height(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }



    public void printLeftView(Node<Integer> root){
        List<Integer> answer = new ArrayList<>();
        Queue<Node<Integer>> q =new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            answer.add(q.peek().value);
            while (size !=0){
                Node<Integer> t = q.poll();
                if(t.leftChild != null){
                    q.add(t.leftChild);
                }
                if(t.rightChild != null){
                    q.add(t.rightChild);
                }
                size--;
            }
        }
        System.out.println(answer);
    }
    public void printLeftViewApproach2(Node<Integer> root){
        List<Integer> answer =new ArrayList<>();
        printLeftViewApproach2Helper(answer,root,0);
        System.out.println(answer);
    }
    private void printLeftViewApproach2Helper(List<Integer> answer,Node<Integer> root, int level){
        if(root == null){
            return;
        }
        if(level == answer.size()){
            answer.add(root.value);
        }
        printLeftViewApproach2Helper(answer,root.leftChild,level+1);
        printLeftViewApproach2Helper(answer,root.rightChild,level+1);
    }
    public void printLeftViewApproach3(Node<Integer> root){
        int totalLevel = getTotalLevel(root);
        int[] visitedLevel = new int[totalLevel];
        List<Integer> answer = new ArrayList<>();
        printLeftViewApproach3Helper(visitedLevel,answer,root,0);
        System.out.println(answer);
    }
    public void printLeftViewApproach3Helper(int[] visitedLevel,List<Integer> answer,Node<Integer> root,int currentLevel){
        if(root == null){
            return;
        }
        if(visitedLevel[currentLevel] == 0){
            answer.add(root.value);
            visitedLevel[currentLevel] = 1;
        }
        printLeftViewApproach3Helper(visitedLevel,answer,root.leftChild,currentLevel+1);
        printLeftViewApproach3Helper(visitedLevel,answer,root.rightChild,currentLevel+1);

    }
    public int getTotalLevel(Node<Integer> root){
        if(root == null){
            return 0;
        }
        int leftDepth = getTotalLevel(root.leftChild);
        int rightDepth = getTotalLevel(root.rightChild);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public void printRightView(Node<Integer> root){
        List<Integer> answer = new ArrayList<>();
        Queue<Node<Integer>> q =new LinkedList<>();
        q.add(root);
        while (! q.isEmpty()) {
            Node<Integer> mostRightNode = null;
            int size = q.size();
            while (size != 0) {
                Node<Integer> temp = q.poll();
                if(temp.leftChild != null){
                    q.add(temp.leftChild);
                }
                if(temp.rightChild != null){
                    q.add(temp.rightChild);
                }
                size--;
                mostRightNode = temp;
            }
            answer.add(mostRightNode.value);
        }
        System.out.println(answer);
    }

    public void printRightViewApproach2(Node<Integer> root){
        List<Integer> answer =new ArrayList<>();
        printRightViewApproach2Helper(answer,root,0);
        System.out.println(answer);
    }
    private void printRightViewApproach2Helper(List<Integer> answer,Node<Integer> root, int level){
        if(root == null){
            return;
        }
       if(level == answer.size() ){
            answer.add(root.value);
        }
        printRightViewApproach2Helper(answer,root.rightChild,level+1);
        printRightViewApproach2Helper(answer,root.leftChild,level+1);
    }



    public static void main(String[] args) {
        BinaryTree5<Integer> btree = new BinaryTree5();
        System.out.println("enter the tree element");
        btree.setRoot(btree.addToBTree());
        btree.printLeftViewApproach3(btree.getRoot());
    }
}
