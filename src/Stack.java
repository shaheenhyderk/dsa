public class Stack {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node top = null;

    public void push(int data) // insert at the beginning
    {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public void pop() {
        if (top == null) {
            System.out.print("Stack Underflow");
            return;
        }

        top = top.next;
    }

    public void display() {
        Node current = top;

        if (top == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Stack q = new Stack();
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        q.push(50);
        q.pop();
        q.display();
    }
}
