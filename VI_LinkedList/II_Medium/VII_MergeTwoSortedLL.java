package VI_LinkedList.II_Medium;

import java.util.ArrayList;
import java.util.Collections;

public class VII_MergeTwoSortedLL {

    //Optimal
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
    public ListNode mergeTwoListsBrute(ListNode list1, ListNode list2) {
        // ✅ Base cases: handle null inputs
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        // ✅ Step 1: Collect all node values from both lists into an ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        // Add values from both lists while both have nodes
        while (temp1 != null && temp2 != null) {
            list.add(temp1.val);
            list.add(temp2.val);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        // Add remaining nodes from list1 (if any)
        while (temp1 != null) {
            list.add(temp1.val);
            temp1 = temp1.next;
        }

        // Add remaining nodes from list2 (if any)
        while (temp2 != null) {
            list.add(temp2.val);
            temp2 = temp2.next;
        }

        // ✅ Step 2: Sort the collected values
        Collections.sort(list);

        // ✅ Step 3: Connect list2 to the end of list1 (to reuse all nodes)
        ListNode temp = list1;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = list2; // list1 and list2 are now connected

        // ✅ Step 4: Overwrite all node values with sorted values
        temp = list1;
        int i = 0;
        while (temp != null) {
            temp.val = list.get(i); // update node value
            i++;
            temp = temp.next;
        }

        // ✅ Step 5: Return the modified head of the merged list
        return list1;
    }

}
