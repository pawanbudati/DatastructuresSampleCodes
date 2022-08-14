import java.util.EmptyStackException;
public class StackMain {
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        System.out.println(stack.isEmpty());
        stack.push(10);
        stack.push(30);
        stack.push(50);
        stack.push(90);
        System.out.println(stack.pop());
        System.out.println();
        stack.peek();
        System.out.println();
        stack.show();
        System.out.println("Stack Empty status ---> "+stack.isEmpty());
    }

    public static class StackLinkedList {
        private int length;
        private Node first;
        private Node last;
        private class Node{
            private int value;
            private Node prev;
            private Node next;
            private Node(int item){
                this.value = item;            
            }
        }
        public void push(int item){
            var node = new Node(item);
            if(first==null){
                first=last=node;
                length++;
            }
            else{
                var temp = last;
                temp.next = node;
                node.prev = temp;
                last = node;
                length++;
            }
        }

        public int pop(){
            if(first == null) throw new EmptyStackException();
            int top = last.value;
            last = last.prev;
            length--;
            return top;
        }

        public boolean isEmpty(){
            return first==null;
        }

        public void peek(){
            if(!isEmpty()) System.out.println(last.value);
            else System.out.println("Stack is empty.");;
        }
        
        public void show(){
            var temp = last;
            while(temp!=null){
                System.out.println(temp.value);
                temp = temp.prev;
            }
        }
    }

}
