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
        ListNode temp = head;

          while(temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
          }
          return prev;
    }
    private ListNode findKth(ListNode temp, int k) {
        int count = 1;
        while(temp != null && count != k) {
            count++;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null) {
          ListNode kth = findKth(temp, k);
          if(kth == null) {
                if(prevNode != null)
                prevNode.next = temp;
                break;
            }
            ListNode nextNode = kth.next;
            kth.next = null;
            reverseLL(temp); 
          if(temp == head) {
                head = kth;
            } else prevNode.next = kth; 
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}