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
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode curr = head;
        int val = -2;
        while(curr != null) {
            if((curr.next != null && curr.val == curr.next.val) || curr.val == val) {
                ListNode next  = curr.next;
                prev.next = next;
                curr.next = null;
                val = curr.val;
                curr = next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}