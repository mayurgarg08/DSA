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
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (temp1 != null || temp2 != null || carry != 0) {
            int sum = (temp1 != null? temp1.val: 0)+(temp2 != null? temp2.val: 0)+carry;
            if(sum >= 10) {
                ListNode node = new ListNode(sum%10);
                temp.next = node;
                carry = sum/10;
                temp = node;
            } else {
                ListNode node = new ListNode(sum);
                temp.next = node;
                carry = 0;
                temp = node;
            }
            if(temp1 == null && temp2 == null && carry!= 0) {
                temp.next = new ListNode(carry);
                carry = 0;
            }
            if(temp1 != null)
            temp1 = temp1.next;
            if(temp2 != null)
            temp2 = temp2.next;
        }
        return dummy.next;
        }
    }
