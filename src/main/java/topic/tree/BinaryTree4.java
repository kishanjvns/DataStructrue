package topic.tree;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author KISHAN
 * @implNote This is the second implementation of BTree, this implementation using recursion to insert left and right value to the BTree
 */
public class BinaryTree4<T> {
    private Node<T> root;

    public BinaryTree4(Node<T> root) {
        this.root = root;
    }

    public BinaryTree4() {

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
        if (root == null) {
            return 0;
        }
        int count = isNonLeaf(root) ? 1 : 0;
        return count + totalNonLeaf(root.leftChild) + totalNonLeaf(root.rightChild);
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


    public boolean isTreeIdentical(Node<T> r1, Node<T> r2) {
        System.out.println("Comparing nodes: r1 = " + (r1 == null ? "null" : r1.value) +
                ", r2 = " + (r2 == null ? "null" : r2.value));
        if (r1 == null && r2 == null) {
            return true;
        }
        if ((r1 == null && r2 != null) || (r2 == null && r1 != null)) {
            return false;
        }
        if (r1.value != r2.value) {
            return false;
        }
        return isTreeIdentical(r1.leftChild, r2.leftChild)
                && isTreeIdentical(r1.rightChild, r2.rightChild);
    }

    /**
     * I can use pre and post order method
     */
    public void mirror(Node<T> node) {
        if (node == null) {
            return;
        }
        Node<T> temp = node.leftChild;
        node.leftChild = node.rightChild;
        node.rightChild = temp;
        mirror(node.leftChild);
        mirror(node.rightChild);

    }

    public boolean isBalancedTree(Node<T> root) {
        AtomicBoolean isValid = new AtomicBoolean(true);
        checkHeight(root, isValid);
        return isValid.get();
    }

    private int checkHeight(Node<T> root, AtomicBoolean isValid) {
        if (root == null) {
            return 0;
        }
        if (!isValid.get()) {
            return -1;
        }
        int l = checkHeight(root.leftChild, isValid);
        int r = checkHeight(root.rightChild, isValid);
        if (Math.abs(l - r) > 1) {
            isValid.set(false);
        }
        return 1 + Math.max(l, r);
    }

    /*
    *      1                             Stack1 and Stack2
       /        \
     2            3
    / \        /    \
   4   5      6      7
  / \ / \    / \    / \
 8  9 10 11 12 13  14  15
* */
    public void levelOrderSpiralTraversal(Node<T> root) {
        if (root == null) {
            return;
        }
        Stack<Node<T>> lStack = new Stack<>();
        Stack<Node<T>> rStack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        rStack.push(root);
        while ((lStack != null && !lStack.isEmpty()) || (rStack != null && !rStack.isEmpty())) {
            while (null != lStack && !lStack.isEmpty()) {
                Node<T> temp = lStack.pop();
                answer.add((Integer) temp.value);
                if (temp.leftChild != null) {
                    rStack.push(temp.leftChild);
                }
                if (temp.rightChild != null) {
                    rStack.push(temp.rightChild);
                }
            }
            while (null != rStack && !rStack.isEmpty()) {
                Node<T> temp = rStack.pop();
                answer.add((Integer) temp.value);
                if (temp.rightChild != null) {
                    lStack.push(temp.rightChild);
                }
                if (temp.leftChild != null) {
                    lStack.push(temp.leftChild);
                }
            }
        }
        System.out.println("Answer \n" + answer);
    }


        /*
    *      1                             Stack1 and Stack2
       /        \
     2            3
    / \        /    \
   4   5      6      7

        */
    public boolean isCousine(Node<Integer> root, int val1, int val2){
        int levelOfVal1 = getLevelByValue(val1,root);
        int levelOfVal2 = getLevelByValue(val2,root);
        if(levelOfVal1 != levelOfVal2){
            return  false;
        }
        return !isParentOf(root,val1,val2);
    }
    public int getLevelByValue(int val,Node<Integer> root){
        Queue<Node<Integer>> queue =new LinkedList<>();
        queue.add(root);
        int level = 0;
        int foundAtLevel =-1;
        while (!queue.isEmpty()){
            int qLength = queue.size();
            while (qLength !=0){
                Node<Integer> temp = queue.poll();
                if(temp.value == val){
                    foundAtLevel = level;
                }
                if(null!= temp.leftChild){
                    queue.add(temp.leftChild);
                }
                if(null!= temp.rightChild){
                    queue.add(temp.rightChild);
                }
                qLength--;

            }
            level++;
        }
        return foundAtLevel;
    }
    public boolean isParentOf(Node<Integer> root,int val1,int val2){
        if(root == null){
            return false;
        }
        if(null != root.leftChild && null != root.rightChild){
            if( root.leftChild.value == val1 && root.rightChild.value == val2 ){
                return true;
            }
            if(root.leftChild.value == val2 && root.rightChild.value == val1){
                return true;
            }
        }
        return isParentOf(root.leftChild,val1,val2) || isParentOf(root.rightChild,val1,val2);
    }


    public static void main(String[] args) {
        BinaryTree4<Integer> btree = new BinaryTree4();
        System.out.println("enter the tree element");
        btree.setRoot(btree.addToBTree());
        System.out.println(btree.isCousine(btree.getRoot(), 6,7));
    }
}
