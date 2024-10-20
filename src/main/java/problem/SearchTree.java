package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTree {
    static class BST  {

        private Node root;

        public BST() {
            this.root = new Node();
        }

        public void put(int value) {
            // your code
            Node newNode = new Node(value);
            if(root.val == null){
                root = newNode;
                return;
            }
            Node current = this.root;
            Node parent= this.root;
            while (current != null){
               if(value > current.val){
                   parent = current;
                   current = current.right;
               }else{
                   parent = current;
                   current = current.left;
               }
            }
            if(value < parent.val){
                parent.left=newNode;
                return;
            }else {
                parent.right=newNode;
                return;
            }
        }

        public boolean contains(int value) {
            if(root == null){
                throw new IllegalArgumentException("root is null");
            }
            boolean isContain = false;
            if(value == root.val){
                isContain = true;
                return isContain;
            }
            Node current = root;
            while (current != null){
                if(value == current.val){
                    isContain =true;
                    break;
                }
                else if(value > current.val){
                    current =current.right;
                }else{
                    current =current.left;
                }

            }
            return isContain;
        }

        public List<Integer> inOrderTraversal() {
            final ArrayList<Integer> acc = new ArrayList<>();
            inOrderTraversal(root, acc);
            return acc;
        }

        private void inOrderTraversal(Node node, List<Integer> acc) {
            if (node == null) {
                return;
            }
            inOrderTraversal(node.left, acc);
            acc.add(node.val);
            inOrderTraversal(node.right, acc);

        }

        private static class Node {
            Integer val;
            Node left;
            Node right;
            public Node(int val){
                this.val=val;
            }
            public Node(){}
        }
    }


    public static void main(String[] args) {

        final BST searchTree = new BST();

        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(5);

        System.out.println(searchTree.inOrderTraversal());
        if(Arrays.asList(1,2,3,5).equals(searchTree.inOrderTraversal())
                && !searchTree.contains(0)
                && searchTree.contains(1)
                && searchTree.contains(2)
                && searchTree.contains(3)
                && !searchTree.contains(4)
                && searchTree.contains(5)
                && !searchTree.contains(6)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

    }
}
