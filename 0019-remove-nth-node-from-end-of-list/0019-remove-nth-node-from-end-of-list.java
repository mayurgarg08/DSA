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
        ListNode first = head;
        ListNode second = head;
        while(n > 0 && first != null) {
            first = first.next;
            n--;
        }
         if (first == null) {
            return head.next;
        }
        while(first != null && first.next != null) {
            first = first.next;
            second = second.next;
        }
        if(second.next != null) second.next = second.next.next;
         return head;
    }
}