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
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode node = head;
        while(node != null) {
            ListNode j = node.next;
            while(j != null && j.val == node.val) {
                j = j.next;
            }
            if (node.next != j) { 
                if (prev == null) {
                    head = j;
                } else {
                    prev.next = j;
                }
            } else { 
                prev = node;
            }
            node = j;
        } 
        return head;
    }
}