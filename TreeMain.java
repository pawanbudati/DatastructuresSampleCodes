public class TreeMain {
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        BSTree tree2 = new BSTree();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(tree.isBinarySearchTree());
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(3);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println(tree.isBinarySearchTree());
        
        tree2.insert(7);
        tree2.insert(4);
        tree2.insert(9);
        tree2.insert(3);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        System.out.println(tree2.isBinarySearchTree());
        // tree2.traversePreOrder();
        // System.out.println();
        // tree.traverseInOrder();
        // System.out.println();
        // tree.traversePostOrder();
        // System.out.println();
        // System.out.println(tree.height());
        // System.out.println(tree.min());
        System.out.println(tree.equals(tree2));
                
    }

    public static class BSTree {
        private Node root;
        private class Node{
            private int value;
            private Node leftChild;
            private Node rightChild;
            public Node(int value)  {   this.value = value;    }
            @Override
            public String toString(){
                return "Node = " + value;
            }
        }
        public boolean find(int item){
            var current = root;
            while(current!=null){
                if(current.value==item) return true;   
                if(item>current.value) current = current.rightChild;
                else if(item<current.value) current = current.leftChild;
            }
            return false;
        }
        private boolean isLeaf(Node node){
        return node.leftChild==null && node.rightChild==null;
        }
        
        public int min(){
            if(root == null) throw new IllegalStateException();
            var current = root;
            while(current.leftChild!=null)  current = current.leftChild;
            return current.value;            
        }

        public void traversePreOrder(){
            traversePreOrder(root);
        }
        public void traverseInOrder(){
            traverseInOrder(root);
        }
        public void traversePostOrder(){
            traversePostOrder(root);
        }

        private void traversePreOrder(Node root2){
            if(root2 == null) return;
            System.out.print(root2.value + " ");
            traversePreOrder(root2.leftChild);
            traversePreOrder(root2.rightChild);
        }
        private void traverseInOrder(Node root2){
            if(root2 == null) return;
            traverseInOrder(root2.leftChild);
            System.out.print(root2.value + " ");
            traverseInOrder(root2.rightChild);
        }
        private void traversePostOrder(Node root2){
            if(root2 == null) return;
            traversePostOrder(root2.leftChild);
            traversePostOrder(root2.rightChild);
            System.out.print(root2.value + " ");
        }

        public int height(){
            return height(root);
        }
        private int height(Node root){
            if(root==null) return -1;
            if(isLeaf(root)) return 0;
            return 1+Math.max(height(root.rightChild),height(root.leftChild));
        }
        
        public boolean equals(BSTree other){
            if(other.root==null) 
                throw new IllegalArgumentException();
            return equals(root,other.root);
        }
        private boolean equals(Node t1,Node t2){
            if(t1==null && t2==null) return true;
            if(t1!=null && t2!=null){
                return t1.value==t2.value && 
                equals(t1.leftChild,t2.leftChild) &&
                equals(t1.rightChild,t2.rightChild);
            }
            return false;
        }

        public boolean isBinarySearchTree(){
            return isBinarySearchTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        private boolean isBinarySearchTree(Node node, int min,int max){
            if(root == null) return true;
            if(root.value < min || root.value > max) return false;
            return 
                isBinarySearchTree(root.leftChild,min,root.value-1) 
                && isBinarySearchTree(root.rightChild,root.value+1,max);
        }

        public void insert(int item){
            var node = new Node(item);
            if(root == null){ 
                root = node;
                return;
            }
                var current = root;
                while(current != null) {
                    if(node.value < current.value) {
                        if(current.leftChild ==null){
                            current.rightChild = node;
                            break;
                        }
                        current = current.leftChild;
                    }
                    else {
                        if(current.rightChild == null){
                            current.leftChild = node;
                            break;
                        }
                        current = current.leftChild;
                        
                    }
                }
            }
    }
}
