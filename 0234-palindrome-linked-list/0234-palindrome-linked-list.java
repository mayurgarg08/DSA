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
    private ListNode reverseLL(ListNode head) {
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
    public boolean isPalindrome(ListNode head) {
       ListNode slow = head;
       ListNode fast = head.next;
       while(fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
       }
       ListNode newHead = reverseLL(slow.next);
       ListNode ptr1 = head;
       ListNode ptr2 = newHead;
       while(ptr1 != null && ptr2 != null) {
          if(ptr1.val != ptr2.val) return false;
          ptr1 = ptr1.next;
          ptr2 = ptr2.next;
       }
       return true;
    }
}