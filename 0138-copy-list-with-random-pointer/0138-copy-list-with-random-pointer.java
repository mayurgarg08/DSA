/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    private void insertCopy(Node head) {
         Node temp = head;
         while(temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
         }
    }
    private void connectRandom(Node head) {
        Node temp = head;
        while(temp != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
    }
    private Node getDeepCopy(Node head) {
        Node dummy = new Node(-1);
        Node res = dummy;
        Node temp = head;
        while(temp != null) {
            res.next = temp.next;
            temp.next = temp.next.next;

            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        insertCopy(head);
        connectRandom(head);
        return getDeepCopy(head);
    }
}