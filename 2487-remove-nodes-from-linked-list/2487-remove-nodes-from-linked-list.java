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
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        int maxi = head.val;
        ListNode curr = head;

        while(curr != null && curr.next != null){
            if(curr.next.val < maxi){
                curr.next = curr.next.next;
            }
            else{
                maxi = curr.next.val;
                curr = curr.next;
            }
        }
        return reverse(head);
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}