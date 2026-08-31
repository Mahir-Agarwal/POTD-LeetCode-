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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        int first = -1;
        int min = Integer.MAX_VALUE;
        int max = -1 ;
        int previ = -1 ;
        int i = 1 ; 
        ListNode prev = head ;
        ListNode curr = head.next ;

        while (curr.next != null){

            if((curr.val > prev.val && curr.val > curr.next.val)||
               (curr.val < prev.val && curr.val < curr.next.val)
            ){

                if(first == -1 ){
                    first = i ; 
                }else{
                    
                    min =Math.min(min , i-previ );
                    max = i-first;
                  
                }
                previ = i ;
            } 
            prev = curr;
            curr = curr.next ;
            i++;
        }

        if(min == Integer.MAX_VALUE) min = -1; 

        return new int [] {min , max};
    }
}