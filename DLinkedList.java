public class DLinkedList {

    private class Node {
        protected int element;
        protected Node next;
        protected Node previous;

        public Node(int element, Node next, Node previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }

        public int getElement() { return element; }
        public Node getNext() { return next; }
        public Node getPrevious() { return previous; }
        public void setElement(int element) { this.element = element; }
        public void setNext(Node next) { this.next = next; }
        public void setPrevious(Node previous) { this.previous = previous; }

    }

    private Node head;
    private Node tail;
    private int size;

    public DLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() { return size; }

    public boolean isEmpty() { return size == 0; }

    public void delete() {
        head.previous = null;
        head.next = null;
        head = tail = null;
        size = 0;
    }

    public void addFirst(int element) {

        if(isEmpty()) {
            Node newNode = new Node(element, null, null);
            head = tail = newNode;
        }
        else {
            Node newNode = new Node(element, head, null);
            head.setPrevious(newNode);
            head = newNode;

        }
        size++;
    }

    public void addLast(int element) {
        if(isEmpty()) {
            Node newNode = new Node(element, null, null);
            tail = head = newNode;
        }
        else {
            Node newNode = new Node(element, null, tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void deleteFirst() {
        if(isEmpty()) {
            return;
        }
        else {

            if(head == tail) {
                delete();
            }

            Node second = head.getNext();

            second.setPrevious(null);
            head = second;

        }
        size--;
    }

    public void deleteLast() {
        if(isEmpty()) {
            return;
        }
        else {
            if(head == tail) {
                delete();
            }
            else if (tail.getPrevious() == head) {
                head = tail;
            }
            else {

                Node beforeLast = tail.getPrevious();
                beforeLast.setNext(null);

            }
        }
        size--;
    }

    public String toString() {

        if(isEmpty()) {
            return "List is empty";
        }

        String result = "";

        Node current = head;
        int index = 0;
        while(current != null) {
            result += String.valueOf(index++) + ".Index " + current.getElement() + "\n";
            current = current.getNext();
        }
        return result;
    }

    public int get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;

        if(head == null) {
            return -1;
        }

        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getElement();
    }

    public void removeElement(int element) {
        if(isEmpty()) {
            return;
        }

        Node current = head;

        for (int i = 0; i < size; i++) {
            if(current.getElement() == element) {
                if(current == head) {
                    head = head.getNext();
                    head.setPrevious(null);
                }
                else if(current == tail) {
                    tail = tail.getPrevious();
                    tail.setNext(null);
                }
                else {
                    Node previous = current.getPrevious();
                    Node next = current.getNext();
                    previous.setNext(next);
                    next.setPrevious(previous);
                }
                size--;
            }
            current = current.getNext();
        }


    }

    public void removeFirst() {
        if(isEmpty()) {
            return;
        }
        else {
            if(head == tail) {
                delete();
            }
            head = head.getNext();
            head.setPrevious(null);
        }
        size--;
    }

    public void removeLast() {
        if(isEmpty()) {
            return;
        }
        else {
            if(head == tail) {
                delete();
            }
            else {
                tail = tail.getPrevious();
                tail.setNext(null);
            }
        }
        size--;
    }


}
