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
    public int findLength(ListNode head) {
        int count = 1;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            count++;
        }
        return count-1;
    }
    public ListNode rotateRight(ListNode head, int k) {
      if(head == null || head.next == null || k == 0) return head;
      int len = findLength(head);
      k = k%len;
      if(k == 0) return head;
      ListNode slow = head;
      ListNode fast = head;
      int count = 0;
      while(count != k) {
        if(fast == null) return head;
        fast = fast.next;
        count++;
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