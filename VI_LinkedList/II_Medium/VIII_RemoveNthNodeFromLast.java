package VI_LinkedList.II_Medium;

public class VIII_RemoveNthNodeFromLast {
    //Optimal approach
    public ListNode removeNthFromEndOptimal(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for(int i=1; i<=n; i++){
            fast = fast.next;
        }

        if(fast == null){
            head = head.next;
            return head;
        }

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    //Brute force
    public ListNode removeNthFromEndBrute(ListNode head, int n){

        ListNode temp = head;
        int count= 0;

        while(temp!=null){
            count++;
            temp = temp.next;
        }

        if(n == count){
            return head.next;
        }

        int res = count-n;
        temp = head;

        while(temp!=null){
            res--;

            if(res == 0){
                break;
            }
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
}
