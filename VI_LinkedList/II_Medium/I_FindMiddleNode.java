package VI_LinkedList.II_Medium;


import java.util.LinkedList;
import VI_LinkedList.I_Easy.LL;

//https://leetcode.com/problems/middle-of-the-linked-list/
public class I_FindMiddleNode {

    //Brute force
//    public ListNode middleNode(ListNode head) {
//        //O(N) + O(N/2) ---> TC
//        if(head == null){
//            return null;
//        }
//
//        ListNode temp = head;
//        int count = 0;
//
//        while(temp != null){
//            count++;
//            temp = temp.next;
//        }
//
//        int mid = (count/2);
//        temp = head;
//
//        while(mid!=0){
//            temp=temp.next;
//            mid--;
//        }
//
//        return temp;
//    }


    //Optimal solution
    //O(N/2)
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
