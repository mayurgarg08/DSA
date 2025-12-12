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
    public Node copyRandomList(Node head) {
        if(head == null) return null; 
        Node temp = head;
        while(temp != null) {
            Node copyNode = new Node(temp.val);
            Node nextElement = temp.next;
            copyNode.next = nextElement;
            temp.next = copyNode; 

            temp = nextElement;
        }
        temp = head; 
        while(temp != null) {
            if(temp.random != null && temp.next != null)
            temp.next.random = temp.random.next;
            else temp.next.random = null;

            temp = temp.next.next;
        }
        Node dummy = new Node(-1);
        Node res = dummy;
        temp = head;
        while(temp != null) {
            res.next = temp.next;
            temp.next = temp.next.next;

            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}