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
        ListNode prev = null;
        ListNode first = head;
        ListNode second = head;
        while(second != null && second.next != null) {
            prev = first;
            first = first.next;
            second = second.next.next;
        }
        prev.next = first.next;
        return head;
    }
}