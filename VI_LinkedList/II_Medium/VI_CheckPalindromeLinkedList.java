package VI_LinkedList.II_Medium;
//https://leetcode.com/problems/palindrome-linked-list/
public class VI_CheckPalindromeLinkedList {
    //Optimal Solution
    public boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse(slow.next);

        ListNode first = head;
        ListNode second = newHead;

        while(second!=null){
            if(first.val != second.val){
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverse(newHead);

        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        ListNode first = null;

        while(temp!=null){
            first = temp.next;
            temp.next = prev;
            prev = temp;
            temp = first;
        }

        return prev;
    }


    //Brute Force Solution
    // public boolean isPalindrome(ListNode head) {
    //     Stack<ListNode> st = new Stack<>();

    //     ListNode temp = head;

    //     while(temp != null){
    //         st.push(temp);
    //         temp = temp.next;
    //     }

    //     temp = head;

    //     while(temp!=null){
    //         if(temp.val != st.pop().val) return false;
    //         temp = temp.next;
    //     }

    //     return true;
    // }
}
