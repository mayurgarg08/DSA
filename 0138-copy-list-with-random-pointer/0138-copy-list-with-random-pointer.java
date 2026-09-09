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
        Node curr = head;
        while(curr != null) {
            Node copy = new Node(curr.val, curr.next);
            curr.next = copy;
            curr = curr.next.next;
        }
    }
    private void connectRandom(Node head) {
        Node curr = head;
        while(curr != null) {
            if(curr.random != null) curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
    }
    private Node getdeepCopy(Node head) {
        Node copyHead = head.next;
        Node curr = head;
        while(curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;
            if(curr.next != null) copy.next = curr.next.next;
            curr = curr.next;
        }
        return copyHead;
    }
    public Node copyRandomList(Node head) {
         if(head == null) return null;
        insertCopy(head);
        connectRandom(head);
        return getdeepCopy(head);
    }
}