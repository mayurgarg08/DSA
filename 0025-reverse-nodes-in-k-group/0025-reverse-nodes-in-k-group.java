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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode temp = head;
        ListNode last = null;
        int count = 0;
        while(temp != null) {
            ++count;
            if(count % k == 0) {
               ListNode next = temp.next;
               temp.next = null;

               ListNode newHead = reverseLL(ptr);
               if(last != null) {
                  last.next = newHead;
               } else {
                   head = newHead;
               }
               ptr.next = next;
               last = ptr;
               ptr = next;
               temp = next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}