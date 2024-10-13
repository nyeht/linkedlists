public class SLinkedList {

    private class Node {
        private int element;
        private Node next;

        public Node(int element, Node next) {
            this.element = element;
            this.next = next;
        }

        SLinkedList s = new SLinkedList();

        public int getElement() { return element; };

        public void setElement(int element) { this.element = element; }

        public Node getNext() { return this.next; }

        public void setNext(Node next) { this.next = next; }

    }

    protected Node head;
    protected Node tail;
    protected int length;

    public SLinkedList() {
        this.head = this.tail = null;
        length = 0;
    }

    public int getLength() {
        return length;
    }

    // Add new element to the tail of the list
    public void addLast(int element) {
        Node newNode = new Node(element, null);
        if(length == 0) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        length++;
    }

    // Add new element to the head of the list
    public void addFirst(int element) {
        Node newNode = new Node(element, head);
        if(length == 0) {
            head = tail = newNode;
        } else {
            head = newNode;
        }
        length++;
    }

    // Return element for specific index
    public int get(int index) {
        if(index >= length) {
            return 404;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current =  current.getNext();
            }
            return current.getElement();
        }
    }

    // Remove first element from list
    public int removeFirst() {
        Node firstElement = head;
        head = head.getNext();
        return firstElement.getElement();
    }

    // Remove last element from list
    public int removeLast() {
        Node lastElement = tail;

        Node current = head;

        while(current.getNext() != tail) {
            current = current.getNext();
        }
        tail = current;
        current.setNext(null);
        return lastElement.getElement();
    }

    // Swap first and second node element
    public void swapElement() {

        if(head == null || head.getNext() == null) {
            System.out.println("List cannot swap");
            return;
        } else {

            Node first = head;
            Node second = head.getNext();

            if(length == 2) {
                tail = new Node(head.getElement(), null);
            }

            first.setNext(second.getNext());
            second.setNext(first);

            head = second;

        }

    }

    // Print all elements
    public String toString() {
        String result = "";

        Node current = head;
        int index = 0;
        while (current != null) {
            result += String.valueOf(index++) + ". index " + current.getElement() + "\n";
            current = current.getNext();
        }
        return result;
    }

    // Insert After specific index
    public void insertAfter(int index, int element) {
        if(index >= length) {
            System.out.println("Invalid index");
            return;
        } else {

            Node current = head;

            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }

            Node after = current.getNext();

            Node newNode = new Node(element, after);

            if(index == length - 1) {
                tail = newNode;
            }

            current.setNext(newNode);

            length++;
        }
    }

    // Insert Before specific index
    public void insertBefore(int index, int element) {
        if(index >= length) {
            System.out.println("Invalid index");
            return;
        } else {

            Node current = head;

            // Find node for index - 1
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }

            Node newNode = new Node(element, current.getNext());

            current.setNext(newNode);

            length++;
        }
    }


}
