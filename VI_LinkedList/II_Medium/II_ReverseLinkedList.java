package VI_LinkedList.II_Medium;

import java.util.Stack;

//https://leetcode.com/problems/reverse-linked-list/
public class II_ReverseLinkedList {

    //Recursive solution
    //TC - n
    //SC - n (for recursion stack)
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }

        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

//    Better solution
//    TC = n
//    SC = 1
//    public ListNode reverseList(ListNode head){
//        if(head == null || head.next==null){
//            return head;
//        }
//
//        ListNode prev = null;;
//        ListNode temp = head;
//        ListNode front = null;
//
//        while(temp != null){
//            front = temp.next;
//            temp.next = prev;
//            prev = temp;
//            temp = front;
//        }
//
//        return prev;
//    }


//    Brute force
//    TC- n+n
//    SC - n
//    public ListNode reverseList(ListNode head){
//        if(head == null){
//            return null;
//        }
//        else if(head.next == null) {
//            return head;
//        }
//
//        Stack<Integer> st = new Stack<>();
//        ListNode temp = head;
//
//        while(temp!=null){
//            st.push(temp.val);
//            temp = temp.next;
//        }
//
//        temp = head;
//
//        while(temp!=null){
//            temp.val = st.pop();
//            temp=temp.next;
//        }
//
//        return head;
//    }


}
