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
    private ListNode nthNode(ListNode head, int k) {
        int count = 1;
        ListNode temp = head;
        while(temp != null && count != k) {
            temp = temp.next;
            count++;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
      if(head == null || head.next == null || k == 0) {
        return head;
      }
      int count = 1;
      ListNode temp = head;
      while(temp.next != null) {
        temp = temp.next;
        count++;
      }
      k = k%count;
      
      if(k == 0) {
        return head;
      }
      temp.next = head;
      ListNode nth = nthNode(head, count-k);
 
      head = nth.next;
      nth.next = null;
      
     return head;
    }
}