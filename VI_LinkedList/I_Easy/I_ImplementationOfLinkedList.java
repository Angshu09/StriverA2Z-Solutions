package VI_LinkedList.I_Easy;

import java.util.LinkedList;

public class I_ImplementationOfLinkedList {
    public static void main(String[] args) {
        //This is in build that provided by java itself...
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(12);
//        list.add(45);
//        System.out.println(list);

        //Custom Linked List
        LL list = new LL();
        list.insertAtFirst(17);
        list.insertAtFirst(12);
        list.insertAtFirst(78);
        list.insertAtLast(90);
        list.insertAtIndex(2, 99);
//        list.displaySize();
        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.deleteAtIndex(1));
        list.display();
    }
}
