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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        if(head.next == null && n == 1) return null;
        ListNode fast = head;
        ListNode slow = head;
        int count = n;
        while(count >= 0 && fast != null) {
            fast = fast.next;
            count--;
        } 
        if(fast == null && count >= 0) {
            return head.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if(slow.next != null) slow.next = slow.next.next;
        return head;
    }
}