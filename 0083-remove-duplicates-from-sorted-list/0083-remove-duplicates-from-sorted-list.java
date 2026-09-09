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
    public ListNode deleteDuplicates(ListNode head) {
       ListNode prev = null;
       ListNode curr = head;
       while(curr != null) {
        if(prev != null && curr.val == prev.val) {
            ListNode next = curr.next;
            prev.next = next;
            curr.next = null;
            curr = next;
        } else {
            prev = curr;
            curr = curr.next;
       }  
     }
       return head; 
    }
}