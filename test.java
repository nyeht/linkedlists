public class test {

    public static void main(String[] args) {

        DLinkedList list = new DLinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(5);

        //list.deleteLast();
        //list.deleteFirst();

        //list.delete();

        //list.removeElement(2);

        list.addLast(10);
        list.addFirst(11);

        list.removeFirst();
        list.removeLast();

        System.out.println(list.getSize());
        System.out.println(list.toString());

        //System.out.println(list.get(3));


/*        SLinkedList list = new SLinkedList();


        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addFirst(6);

        // list.swapElement();

        list.insertAfter(1,10);

        list.insertBefore(3,19);

        //System.out.println(list.removeLast());
        //System.out.println(list.removeFirst());

        //System.out.println(list.getLength());
        //System.out.println(list.get(0));

        System.out.println(list.toString());*/


    }

}
