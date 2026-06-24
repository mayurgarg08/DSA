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
        if(head == null || head.next == null) {
            return head;
        }
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
    private ListNode getKthNode(ListNode temp, int k) {
        k -= 1;
        while(temp != null && k > 0) {
            k--;
            temp = temp.next;
        } 
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null) {
            ListNode kthNode = getKthNode(temp, k);
            if(kthNode == null) {
               if(prev != null) prev.next = temp;
               break;
            }
            ListNode next = kthNode.next;
            kthNode.next = null;
            reverseLL(temp);
            if(temp == head) {
                head = kthNode;
            } else {
                prev.next = kthNode;
            }
            prev = temp;
            temp = next;
        }
        return head;
    }
}