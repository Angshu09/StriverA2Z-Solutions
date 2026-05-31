package VI_LinkedList.II_Medium;

import java.util.HashMap;

//https://leetcode.com/problems/linked-list-cycle/description/
public class III_DetectLoopInLinkedList {

    //Optimal code
    public boolean hasCycleOptimal(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true; // cycle detected
            }
        }

        return false; // no cycle found
    }


    //Brute force code
    public boolean hasCycleBrute(ListNode head) {
        ListNode temp = head;
        HashMap<ListNode, Integer> map = new HashMap<>();

        while(temp != null){
            if(map.containsKey(temp)){
                return true; // cycle detected
            } else {
                map.put(temp, 1); // mark visited
                temp = temp.next;
            }
        }

        return false; // no cycle found
    }

}
