package VI_LinkedList.II_Medium;

import java.util.HashMap;

//https://www.geeksforgeeks.org/problems/find-length-of-loop/1
public class V_FindTheLengthOfLoop {

    //Optimal Approach
    public int countNodesinLoopOptimal(ListNode head) {
        if (head == null || head.next == null) return 0;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect loop using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Loop found, count the number of nodes in loop
                int count = 1;
                ListNode temp = slow;
                while (temp.next != slow) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }
        }

        return 0; // No loop
    }

    //Better approach
    public int countNodesinLoopBetter(ListNode head) {
        if(head == null || head.next == null){
            return 0;
        }
        // code here.
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;

                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }

                break;
            }
        }

        if(fast != slow){
            return 0;
        }

        int count = 0;

        while(fast.next != slow){
            count += 1;
            fast = fast.next;
        }

        return count+1;
    }

    //Brute
    public int countNodesinLoop(ListNode head){
        if(head == null || head.next == null) return 0;

        HashMap<ListNode, Integer> map = new HashMap<>();

        int count = 1;

        ListNode temp = head;

        while(temp != null){
            if(map.containsKey(temp)){
                return count - map.get(temp);
            }
            map.put(temp, count);
            count++;
            temp = temp.next;
        }

        return 0;
    }
}
