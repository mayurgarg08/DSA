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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            ListNode newNode  = new ListNode(sum%10);
            curr.next = newNode;
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }
        if(l1 != null) {
            while(l1 != null) {
                int newSum = l1.val + carry;
               curr.next = new ListNode(newSum % 10);
               carry = newSum /10;
               curr = curr.next;
               l1 = l1.next;
            }
        }
        if(l2 != null) {
            while(l2 != null) {
                int newSum = l2.val + carry;
               curr.next = new ListNode(newSum % 10);
               carry = newSum /10;
               curr = curr.next;
               l2 = l2.next;
            }
        }
        if(carry > 0) {
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }
        return dummy.next;
    }
}