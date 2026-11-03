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
    private ListNode findmid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode ptr3 = dummy;
        while(ptr1 != null && ptr2 != null) {
            if(ptr1.val <= ptr2.val) {
                ptr3.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                ptr3.next = ptr2;
                ptr2 = ptr2.next;
            }
            ptr3 = ptr3.next;
        }
        if (ptr1 != null) {
            ptr3.next = ptr1;
        }
        else {
            ptr3.next = ptr2;
        }
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
       if(head == null || head.next == null) return head;
       ListNode mid = findmid(head);
       ListNode head2 = mid.next;
       mid.next = null;
       ListNode list1 = sortList(head);
       ListNode list2 = sortList(head2);
       return merge(list1, list2);  
    }
}