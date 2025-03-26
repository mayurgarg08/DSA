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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode reshead = new ListNode();
        ListNode temp = reshead;
     while(list1 != null && list2 != null) {
        if(list1.val < list2.val) {
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        } else {
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }
     }
     temp.next = (list1 != null) ? list1 : list2;
      return reshead.next;
   }
  private ListNode getMid(ListNode head) {
       ListNode midprev = null;
       while(head != null && head.next != null) {
        midprev = (midprev == null) ? head : midprev.next;
        head = head.next.next;
       }
       ListNode mid = midprev.next;
       midprev.next = null;
       return mid;
  }
}