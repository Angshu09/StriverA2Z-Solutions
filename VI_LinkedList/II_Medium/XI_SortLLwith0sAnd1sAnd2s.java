package VI_LinkedList.II_Medium;
//https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
public class XI_SortLLwith0sAnd1sAnd2s {

    //Better
    static ListNode segregate(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);
        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;
        ListNode temp = head;

        while(temp!=null){
            if(temp.val == 0){
                zero.next = temp;
                zero = temp;
            }
            else if(temp.val == 1){
                one.next = temp;
                one = temp;
            }
            else{
                two.next = temp;
                two = temp;
            }

            temp = temp.next;
        }

        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next  = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }

    //Brute Force
    static ListNode segregateBrute(ListNode head) {
        // code here
        ListNode temp = head;
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        while(temp!=null){
            if(temp.val == 0){
                cnt0++;
            }
            else if(temp.val == 1){
                cnt1++;
            }
            else{
                cnt2++;
            }

            temp = temp.next;
        }

        temp = head;


        while(temp != null){
            if(cnt0!=0){
                temp.val = 0;
                cnt0--;
            }
            else if(cnt1!=0){
                temp.val = 1;
                cnt1--;
            }
            else{
                temp.val = 2;
                cnt2--;
            }
            temp=temp.next;
        }

        return head;
    }
}
