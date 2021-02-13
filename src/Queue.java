public class Queue {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node front = null;
    public Node rear = null;

    void enqueue(int data) {

        Node temp = new Node(data);

        if (rear == null) {
            front = rear = temp;
            return;
        }

        rear.next = temp;
        rear = temp;
    }


    void dequeue() {
        if (front == null)
            return;

        front = front.next;

        if (front == null)
            rear = null;
    }

    public void display() {
        Node current = front;

        if (front == null) {
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
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        q.display();
    }
}
