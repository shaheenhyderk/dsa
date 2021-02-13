
public class s {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void display() {
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    void deleteNode(int value) {
        Node current = head, prev = null;

        if (current != null && current.data == value) {
            head = current.next;
            return;
        }

        while (current != null && current.data != value) {
            prev = current;
            current = current.next;
        }

        if (current == null)
            return;

        prev.next = current.next;
    }

    void insertAfter(int nodeValue, int value) {
        Node current = head;
        Node newNode = new Node(value);

        while (current != null && current.data != nodeValue) {
            current = current.next;
        }

        if (current == null)
            return;

        newNode.next = current.next;
        current.next = newNode;

    }

    public static void main(String[] args) {

        s sList = new s();

        sList.addNode(1);
        sList.addNode(2);
        sList.addNode(3);
        sList.addNode(4);
        sList.deleteNode(3);
        sList.insertAfter(2, 5);

        sList.display();
    }



}
