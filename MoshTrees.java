import java.util.ArrayList;

public class MoshTrees {
    public static void main(String[] args) {
        Tree tree = new Tree();
        // System.out.println(tree.size());
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        // System.out.println(tree.size());
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println(tree.isBinarySearchTree());
        // System.out.println(tree.size());
        // System.out.println(tree.countLeaves());
    }
    public static class Tree {
        private int size;
        public int size(){
          return size;
        }
        private class Node {
          private int value;
          private Node leftChild;
          private Node rightChild;
      
          public Node(int value) {
            this.value = value;
          }
      
          @Override
          public String toString() {
            return "Node=" + value;
          }
        }
        private Node root;
        private ArrayList<Integer> templist = new ArrayList<>();
        public void insert(int value) {
          var node = new Node(value);
      
          if (root == null) {
            root = node;
            size++;
            return;
          }
          
          var current = root;
          size++;
          while (true) {
            if (value < current.value) {
              if (current.leftChild == null) {
                current.leftChild = node;
                break;
              }
              current = current.leftChild;
            }
            else {
              if (current.rightChild == null) {
                current.rightChild = node;
                break;
              }
              current = current.rightChild;
            }
          }
    }
        public void traversePreOrder(){
        traversePreOrder(root);
    }
        private void traversePreOrder(Node root2){
        if(root2 == null) return;
              System.out.println(root2.value);
              traversePreOrder(root2.leftChild);
              traversePreOrder(root2.rightChild);
          }
        public boolean find(int value) {
          var current = root;
          while (current != null) {
            if (value < current.value)
              current = current.leftChild;
            else if (value > current.value)
              current = current.rightChild;
            else
              return true;
          }
          return false;
        }
        public boolean isBinarySearchTree(){
            return isBinarySearchTree(root,Integer.MIN_VALUE,214748364);
        }
        private boolean isBinarySearchTree(Node node, int min,int max){
            if(root == null) 
                return true;
            System.out.println(root.value);
            // System.out.println(Integer.MIN_VALUE);
            // System.out.println(root.value < min);
            // System.out.println(Integer.MAX_VALUE);
            // System.out.println(root.value);
            System.out.println(root.value > max);
            if(root.value < min || root.value > max){ 
                return false;
            }
            return 
                isBinarySearchTree(root.leftChild,min,root.value-1) 
                && isBinarySearchTree(root.rightChild,root.value+1,max);
        }
        public ArrayList nodeFromKdist(int dist){
            nodeFromKdist(dist,root);
            return templist;
        }
        private void nodeFromKdist(int dist, Node root){
            if(root == null) return;
            if(dist == 0){
                // System.out.println(root.value);
                templist.add(root.value);
                return;
            }
            nodeFromKdist(dist-1, root.leftChild);
            nodeFromKdist(dist-1, root.rightChild);
        }        
        // public int countLeaves(){
        //   return countLeaves(root,0);
        // }
        // private int countLeaves(Node root,int len){
        //   if(root==null) len++;
        //   countLeaves(root.leftChild,len);
        //   countLeaves(root.rightChild,len);
        //   return len;
        // }
  }
}
