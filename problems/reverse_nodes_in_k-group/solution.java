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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        while(true) {
            ListNode temp = new ListNode();
            int count = 0;
            temp = current;
            
            while(temp != null && count < k) {
                temp = temp.next;
                count++;
            }
       
            if(count < k) {
                break;
            }     
            
            ListNode last = prev;
            ListNode newEnd = current;
            ListNode next = current.next;
           
            for(int i = 0; i<k && current != null; i++) {
                current.next = prev;
                prev = current;
                current = next;

                if(next != null) {
                    next = next.next;
                }
            } 
            if(last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            if(current == null) {
                break;
            }

            prev = newEnd;
        }
        return head;
    }
}