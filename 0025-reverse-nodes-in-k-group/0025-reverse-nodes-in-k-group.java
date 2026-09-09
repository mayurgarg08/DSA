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
    public ListNode reverseLL(ListNode head) {
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
        ListNode temp = head;
        ListNode curr = head;
        ListNode last = null;
        int count = 0;
        while(curr != null) {
            ++count;
            if(count%k == 0) {
                ListNode kthNode = curr;
                ListNode next = curr.next;
                kthNode.next = null;
    
                ListNode newHead = reverseLL(temp);

                if(last != null) {
                    last.next = newHead;
                } else {
                    head = newHead;
                }

                temp.next = next;
                last = temp;
                temp = next;
                curr = next; 
            }
            else curr = curr.next;
        }
        return head;
    }
}