package VI_LinkedList.I_Easy;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    // Constructor to initialize an empty LinkedList
    public LL(){
        this.size = 0;
    }

    // ✅ Insert a node at the beginning of the list
    // TC: O(1)
    public void insertAtFirst(int val){
        Node node = new Node(val);  // create a new node
        node.next = head;           // point new node to current head
        head = node;                // update head

        if(tail == null){
            tail = head;           // if list was empty, update tail too
        }

        ++size;                    // increment size
    }

    // ✅ Insert a node at the end of the list
    // TC: O(1) (because tail is maintained), otherwise O(N)
    public void insertAtLast(int val){
        if(tail == null){         // if list is empty, insert at first
            insertAtFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;        // connect current tail to new node
        tail = node;             // update tail
        ++size;
    }

    // ✅ Insert a node at a specific index
    // TC: O(N) in worst case (need to traverse to index)
    public void insertAtIndex(int index, int val){
        if(index == 0){
            insertAtFirst(val);
            return;
        }
        if(index == size){
            insertAtLast(val);
            return;
        }
        if(index > size){
            System.out.println("Your given index " +index+  ", is out of bound");
            return;
        }

        Node temp = head;
        for(int i =1; i<index; i++){  // traverse to index - 1
            temp = temp.next;
        }

        Node node = new Node(val, temp.next); // connect new node with next node
        temp.next = node;                     // update previous node's next
        ++size;
    }

    // ✅ Delete the first node and return its value
    // TC: O(1)
    public int deleteFirst(){
        int val = head.value;
        head = head.next;         // move head to next

        if(head == null){         // if list becomes empty, set tail to null
            tail = null;
        }

        size--;                   // decrease size
        return val;
    }

    // ✅ Delete the last node and return its value
    // TC: O(N) because need to find second last node
    public int deleteLast(){
        if(size <= 1){
            return deleteFirst(); // handles empty and single-node cases
        }

        Node secondLast = getNode(size-2); // get second last node
        int val = tail.value;
        tail = secondLast;                // update tail
        secondLast.next = null;          // remove last node
        return val;
    }

    // ✅ Delete node at given index
    // TC: O(N) in worst case
    public int deleteAtIndex(int index){
        if(index == 0){
            return deleteFirst();
        }

        if(index == size-1){
            return deleteLast();
        }

        Node prev = getNode(index-1);   // get previous node
        int val = prev.next.value;
        prev.next = prev.next.next;     // skip over the deleted node

        return val;
    }

    // ✅ Utility to get node at specific index
    // TC: O(N)
    private Node getNode(int index){
        Node temp = head;
        for(int i=1; i<=index; i++){
            temp = temp.next;
        }
        return temp;
    }

    // ✅ Display the entire linked list
    // TC: O(N)
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value);
            System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ✅ Display the current size of the linked list
    // TC: O(1)
    public void displaySize(){
        System.out.println(this.size);
    }

    // ✅ Inner Node class
    private class Node {
        private int value;
        private Node next;

        // Constructor with only value
        public Node(int value){
            this.value = value;
        }

        // Constructor with value and next node reference
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
