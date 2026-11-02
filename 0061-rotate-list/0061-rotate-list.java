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
    private int length(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
           count++;
           temp = temp.next;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int len = length(head);
        k = k%len;
        if(k == 0) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(k > 0) {
            fast = fast.next;
            k--;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}