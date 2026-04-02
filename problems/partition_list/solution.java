class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while(prev.next != null && prev.next.val < x) {
            prev = prev.next;
        }

        ListNode prev2 = prev;
        ListNode temp = prev.next;

        while(temp != null) {
            if(temp.val < x) {
                prev2.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
                prev = temp;

                temp = prev2.next;
            } else {
                prev2 = temp;   
                temp = temp.next;
            }
        }

        return dummy.next;
    }
}