package VI_LinkedList.II_Medium;

import java.util.HashMap;

public class IV_LinkedListCycleII {
    //Optimal solution
    public ListNode detectCycleOptimal(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;

                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; // start of the cycle
            }
        }

        return null; // no cycle
    }


    //Brute force
    public ListNode detectCycleBrute(ListNode head) {
        ListNode temp = head;
        HashMap<ListNode, Integer> map = new HashMap<>();

        while(temp != null){
            if(map.containsKey(temp)){
                return temp; // cycle detected; return start node
            }
            map.put(temp, 1); // mark as visited
            temp = temp.next;
        }

        return null; // no cycle
    }

}
