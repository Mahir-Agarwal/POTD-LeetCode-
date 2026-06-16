/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
        if(head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = null ;
        while(fast!= null && fast .next != null){
            prevSlow = slow ;
            slow = slow.next;
            fast = fast.next.next ;
        }

        prevSlow.next = prevSlow.next.next;

        return head;
    }
}
//T.C -> O(n) , n is size of linked list ;3612. Process String with Special Operations I