package VI_LinkedList.II_Medium;

public class IX_DeleteMiddleNodeOfLL {

    //Optimal
    public ListNode deleteMiddleOptimal(ListNode head) {
        if(head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next.next!=null && fast.next.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    //Brute force
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null; // Single node case

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int mid = count / 2;
        temp = head;

        for (int i = 0; i < mid - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
}
