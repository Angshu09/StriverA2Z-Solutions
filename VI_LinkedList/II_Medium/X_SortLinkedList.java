package VI_LinkedList.II_Medium;

import java.util.ArrayList;
import java.util.Collections;

//https://leetcode.com/problems/sort-list/description/
public class X_SortLinkedList {

    //Optimal
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = findMid(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return mergeLists(leftHead, rightHead);
    }

    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(temp1!=null && temp2!=null){
            if(temp1.val < temp2.val){
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            }
            else{
                temp.next = temp2;
                temp = temp2;
                temp2 = temp2.next;
            }
        }

        if(temp1 == null){
            temp.next = temp2;
        }
        else{
            temp.next = temp1;
        }

        return dummy.next;
    }


    //Brute force
    public ListNode sortListBrute(ListNode head) {
        ListNode temp = head;
        ArrayList<Integer> list = new ArrayList<>();

        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(list);
        temp = head;
        int i=0;
        while(temp!=null){
            temp.val = list.get(i);
            i++;
            temp = temp.next;
        }

        return head;
    }
}
