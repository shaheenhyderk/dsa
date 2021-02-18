public class SLinkedList {
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
        Node temp = head, prev = null;

        if (temp != null && temp.data == value) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != value) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null)
            return;

        prev.next = temp.next;
    }

    void insertAfter(int nodeValue, int value) {
        Node temp = head;
        Node newNode = new Node(value);

        while (temp != null && temp.data != nodeValue) {
            temp = temp.next;
        }

        if (temp == null)
            return;

        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void removeDuplicates() {
        Node currentNode = head;
        while (currentNode != null) {
            Node nextDistinctNode = currentNode.next;
            while (nextDistinctNode != null && nextDistinctNode.data == currentNode.data) {
                nextDistinctNode = nextDistinctNode.next;
            }

            currentNode.next = nextDistinctNode;

            if (nextDistinctNode == null) {
                tail = currentNode;
            }

            currentNode = nextDistinctNode;
        }
    }

    public static void main(String[] args) {

        SLinkedList sList = new SLinkedList();

        sList.addNode(1);
        sList.addNode(2);
        sList.addNode(3);
        sList.addNode(3);
        sList.addNode(3);
        sList.addNode(2);
        sList.addNode(4);
        sList.addNode(4);
        sList.deleteNode(3);
//        sList.removeDuplicates();
        sList.insertAfter(2, 5);

        sList.display();
        System.out.println(sList.tail.data);
    }

}