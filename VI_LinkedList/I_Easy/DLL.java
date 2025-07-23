package VI_LinkedList.I_Easy;

public class DLL {

    Node head;

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        if(head != null){
            head.prev = node;
        }
        head = node;
    }

    public void insertLast(int val){
        if(head == null){
            insertFirst(val);
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node node = new Node(val);
        temp.next = node;
        node.prev = temp;

    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value);
            System.out.print(" <--> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayReverse(){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        while(temp != null){
            System.out.print(temp.value + " <--> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }


    private class Node {
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
