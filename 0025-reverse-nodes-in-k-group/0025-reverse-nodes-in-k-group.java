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
    private void reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        ListNode curr = head;
        ListNode last = null;
        while(curr != null) {
            ++count;
             
            if(count%k == 0) {
                ListNode kthNode = curr;
                ListNode nextNode = curr.next;
                kthNode.next = null;
                if(temp == head) head = kthNode;
                
                reverseLL(temp);
                if(last != null) last.next = kthNode;
                last = temp;
                
                temp.next = nextNode;
                curr = nextNode;
                temp = nextNode;
            }
            else curr = curr.next;
        }
        return head;
    }
}