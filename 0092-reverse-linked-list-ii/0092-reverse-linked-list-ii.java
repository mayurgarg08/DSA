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
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev = null;
        int count = 0;
        while(curr != null) {
            ++count;
            if(count == left) {
                ListNode newTail = curr;
                ListNode previous = null;
                while(count <= right) {
                   ListNode next = curr.next;
                   curr.next = previous; 
                   previous = curr;
                   curr = next;
                   count++;
                }
             if (prev == null) {
               head = previous;
             } else {
                prev.next = previous;
             }
             if(newTail != null) newTail.next = curr;
             return head;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}